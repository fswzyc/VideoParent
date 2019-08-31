package com.xcy.video.controller;


import com.xcy.video.pojo.User;
import com.xcy.video.pojo.Video;
import com.xcy.video.service.UserService;
import com.xcy.video.utils.ImageCut;
import com.xcy.video.utils.MD5Utils;
import com.xcy.video.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserManage {

    @Value("${IMAGE_DIR}")
    String imageDir;

    @Value("${IMAGE_URL}")
    String imageURL;

    @Autowired
    UserService userService;

    @RequestMapping("/loginUser.action")
    @ResponseBody
    public String user(User user, HttpSession session) {

        String password = user.getPassword();
        String md5 = MD5Utils.getMd5(password);
        user.setPassword(md5);

        boolean b = userService.selectUser(user);

        if (b) {
            session.setAttribute("userAccount", user.getEmail());
            return "success";
        } else {
            return "fail";
        }

    }

    @RequestMapping("/validateEmail.action")
    @ResponseBody
    public String validateEmail(User user) {
        boolean Email = userService.selectEmail(user);
        if (Email) {
            return "fail";
        } else {
            return "success";
        }
    }

    @RequestMapping("/insertUser.action")
    @ResponseBody
    public String insertUser(User user) {

        String password = user.getPassword();
        String md5 = MD5Utils.getMd5(password);
        user.setPassword(md5);

        boolean a = userService.insertUser(user);
        if (a) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/loginOut")
    @ResponseBody
    public String loginOut(HttpSession session) {
        session.removeAttribute("userAccount");
        return "fail";
    }

    @RequestMapping("/showMyProfile.action")
    public String showMyProfile(Model model, HttpSession session) {
        String email = (String) session.getAttribute("userAccount");
        User user = userService.selectUserByEmail(email);
        model.addAttribute("user", user);
        return "before/my_profile";
    }

    @RequestMapping("/changeProfile.action")
    public String changeProfile(Model model, HttpSession session) {
        String email = (String) session.getAttribute("userAccount");
        User user = userService.selectUserByEmail(email);
        user.setImgUrl(imageURL + user.getImgUrl());
        model.addAttribute("user", user);
        return "before/change_profile";
    }

    @RequestMapping("/updateUser.action")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/user/showMyProfile.action";
    }

    @RequestMapping("/passwordSafe.action")
    public String passwordSafe(HttpSession session, Model model) {

        String email = (String) session.getAttribute("userAccount");
        User user = userService.selectImgByEmail(email);
        user.setImgUrl(imageURL + user.getImgUrl());
        model.addAttribute("user", user);

        return "before/password_safe";
    }

    @RequestMapping("/validatePassword.action")
    @ResponseBody
    public String validatePassword(HttpSession session, User user) {
        String email = (String) session.getAttribute("userAccount");
        user.setEmail(email);
        boolean a = userService.validatePassword(user);
        if (a) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/updatePassword.action")
    public String updatePassword(User user, HttpSession session) {
        String email = (String) session.getAttribute("userAccount");
        user.setEmail(email);
        userService.updatePassword(user);
        return "redirect:/user/showMyProfile.action";
    }

    @RequestMapping("/changeAvatar.action")
    public String changeAvatar(HttpSession session, Model model) {

        String email = (String) session.getAttribute("userAccount");

        User user = userService.selectImgByEmail(email);
        user.setImgUrl(imageURL + user.getImgUrl());
        model.addAttribute("user", user);

        return "before/change_avatar";
    }

    @RequestMapping("/upLoadImage.action")
    public String upLoadImage(HttpServletRequest request, MultipartFile image_file, HttpSession session) throws IOException {
        String x1 = request.getParameter("x1");
        String x2 = request.getParameter("x2");
        String y1 = request.getParameter("y1");
        String y2 = request.getParameter("y2");

        String oldFilename = image_file.getOriginalFilename();

        String suffixName = oldFilename.substring(oldFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString().replace("-", "") + suffixName;

        //为了将图片进行归类，我们可以以时间的形式进行文件夹的创建
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
        String dirName = simpleDateFormat.format(date);
        //E\\imgs\
        String targetName = imageDir + dirName;

        File file = new File(targetName);
        if (!file.exists()) {
            file.mkdirs();
        }
        //使用 MulitpartFile 接口中方法，把上传的文件写到指定位置
        image_file.transferTo(new File(targetName, newFileName));

        //图片切割
        float x1Val = 0, x2Val = 0, y1Val = 0, y2Val = 0, width = 0, height = 0;

        if (null != x1 && !x1.equals("")) {
            x1Val = Float.parseFloat(x1);
            y1Val = Float.parseFloat(y1);
            x2Val = Float.parseFloat(x2);
            y2Val = Float.parseFloat(y2);
            width = x2Val - x1Val;
            height = y2Val - y1Val;
            ImageCut imageCut = new ImageCut();
            //System.out.println(targetName+newFileName);
            imageCut.cutImage(targetName + "\\" + newFileName, (int) x1Val, (int) y1Val, (int) width, (int) height);

        }

        String email = (String) session.getAttribute("userAccount");
        String imgUrl = dirName + "/" + newFileName;

        User user = new User();
        user.setImgUrl(imgUrl);
        user.setEmail(email);
        userService.updateUserImageByEmail(user);

        return "redirect:/user/showMyProfile.action";
    }

    @RequestMapping("/forgetPassword.action")
    public String forgetPassword(){

        return "before/forget_password";
    }

    @RequestMapping("/sendEmail.action")
    @ResponseBody
    public String sendEmail(String email){

        String validateCode = MailUtils.getValidateCode(6);
        MailUtils.sendMail(email,"您好:<br/>您本次的验证码是"+validateCode+",请于两小时内输入，否则失效。","Y先生学习网忘记密码验证码邮件");
        User user =new User();
        user.setEmail(email);
        user.setCode(validateCode);
        userService.updateUserValidateCodeByEmail(user);
        return "success";
    }

    @RequestMapping("/validateEmailCode.action")
    public String validateEmailCode(User user,Model model){

        boolean a = userService.validateEmailCode(user);
        if (a){
            model.addAttribute("email",user.getEmail());
            return "before/reset_password";
        }else {
            return "before/forget_password";
        }

    }

    @RequestMapping("/resetPassword.action")
    public String resetPassword(User user){
        userService.resetPassword(user);
        return "redirect:../index.jsp";
    }

    @RequestMapping("/updatePalyNum.action")
    public String updatePalyNum(Video video){
        int newPlayNum = video.getPlayNum() + 1;
        video.setPlayNum(newPlayNum);
        userService.updatePalyNum(video);
        return "success";
    }
}
