package com.xcy.video.service;


import com.xcy.video.pojo.User;
import com.xcy.video.pojo.Video;

public interface UserService {

    boolean selectUser(User user);

    boolean selectEmail(User user);

    boolean insertUser(User user);

    User selectUserByEmail(String email);

    void updateUser(User user);

    boolean validatePassword(User user);

    void updatePassword(User user);

    User selectImgByEmail(String email);

    void updateUserImageByEmail(User user);

    void updateUserValidateCodeByEmail(User user);

    boolean validateEmailCode(User user);

    void resetPassword(User user);

    void updatePalyNum(Video video);
}
