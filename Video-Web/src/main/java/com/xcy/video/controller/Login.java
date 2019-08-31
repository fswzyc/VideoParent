package com.xcy.video.controller;


import com.xcy.video.pojo.Admin;
import com.xcy.video.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Login {
   @Autowired
   AdminService adminService;

    @RequestMapping("/showLogin")
    public String showLogin() {
        return "behind/login";

    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(Admin admin) {
        boolean result = adminService.validateLogin(admin);
        if (result){
            return "success";
        }else{
            return "fail";

        }


    }
}

