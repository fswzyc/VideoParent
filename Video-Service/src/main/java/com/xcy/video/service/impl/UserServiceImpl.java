package com.xcy.video.service.impl;

import com.xcy.video.mapper.UserMapper;
import com.xcy.video.pojo.User;
import com.xcy.video.pojo.Video;
import com.xcy.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    public boolean selectUser(User user) {

        int user1 = mapper.selectUser(user);

        if(user1 > 0){
            return true;
        }else {
            return false;
        }

    }


    public boolean selectEmail(User user) {
        int Email = mapper.selectEmail(user);
        if (Email > 0){
            return true;
        }else{
            return false;
        }
    }


    public boolean insertUser(User user) {
        int b = mapper.insertUser(user);

       if (b > 0){
           return true;
       }else{
           return false;
       }
    }


    public User selectUserByEmail(String email) {
        User user = mapper.selectUserByEmail(email);
        return user;
    }


    public void updateUser(User user) {
        mapper.updateUser(user);

    }


    public boolean validatePassword(User user) {
        int a = mapper.validatePassword(user);
        if(a > 0){
            return true;
        }else {
            return false;
        }
    }


    public void updatePassword(User user) {
        mapper.updatePassword(user);
    }

   /* public void updateUserImageByEmail(String fileName, String email) {

        User user = new User();
        user.setImgUrl(fileName);
        user.setEmail(email);
        mapper.updateUserImageByEmail(user);

    }
*/
    public User selectImgByEmail(String email) {
        User user = mapper.selectImgByEmail(email);
        return user;
    }

    public void updateUserImageByEmail(User user) {

        mapper.updateUserImageByEmail(user);
    }

    public void updateUserValidateCodeByEmail(User user) {
        mapper.updateUserValidateCodeByEmail(user);
    }

    public boolean validateEmailCode(User user) {
        int a = mapper.validateEmailCode(user);
        if (a > 0){
            return true;
        }else {
            return false;
        }

    }

    public void resetPassword(User user) {
        mapper.resetPassword(user);
    }

    public void updatePalyNum(Video video) {
        mapper.updatePalyNum(video);
    }


}
