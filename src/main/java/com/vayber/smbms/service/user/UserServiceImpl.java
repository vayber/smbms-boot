package com.vayber.smbms.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vayber.smbms.bean.MyPage;
import com.vayber.smbms.bean.User;
import com.vayber.smbms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList(String userName,Integer userRole) {
        return userMapper.getUserList( userName,userRole);
    }

    @Override
    public List<User> selectPage(String userName, Integer userRole, MyPage myPage) {
        return userMapper.selectPage(userName,userRole,myPage);
    }



}
