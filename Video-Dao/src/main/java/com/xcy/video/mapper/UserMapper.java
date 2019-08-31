package com.xcy.video.mapper;


import com.xcy.video.pojo.User;
import com.xcy.video.pojo.Video;

public interface UserMapper {
    int selectUser(User user);

    int selectEmail(User user);

    int insertUser(User user);

    User selectUserByEmail(String email);

    void updateUser(User user);

    int validatePassword(User user);

    void updatePassword(User user);

    void updateUserImageByEmail(User user);

    User selectImgByEmail(String email);

    void updateUserValidateCodeByEmail(User user);

    int validateEmailCode(User user);

    void resetPassword(User user);

    void updatePalyNum(Video video);
}
