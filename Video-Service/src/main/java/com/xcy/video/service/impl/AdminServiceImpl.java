package com.xcy.video.service.impl;


import com.xcy.video.mapper.AdminMapper;
import com.xcy.video.pojo.Admin;
import com.xcy.video.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    public boolean validateLogin(Admin admin) {

       //int result= adminMapper.isLogin(admin);
        int result1= adminMapper.validateLogin(admin);

        //return result1 >0 ? true:false;
        if (result1 > 0) {
            return true;
        }else {
            return false;
        }
    }
}
