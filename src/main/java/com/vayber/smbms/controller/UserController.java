package com.vayber.smbms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.vayber.smbms.bean.MyPage;
import com.vayber.smbms.bean.User;
import com.vayber.smbms.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;



    //用户登录
    @RequestMapping("/login")
    public User login(@RequestParam(value = "userCode",defaultValue = "")String userCode,@RequestParam(value = "userPassword",defaultValue = "")String userPassword){
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.eq("userCode",userCode);
        wrapper.eq("userPassword",userPassword);

        return userService.getOne(wrapper,false);
    }


    //查询用户列表
    @Deprecated
    @RequestMapping("/queryList")
    public List<User> queryList(@RequestParam(value = "userName",defaultValue = "") String userName, @RequestParam(value = "userRole",required = false) Integer userRole){



        return userService.getUserList(userName,userRole);
    }



    //分页查询用户列表
    @RequestMapping("/queryPageList")
    public List<User> queryPageList(@RequestParam(value = "userName",defaultValue = "") String userName,
                                    @RequestParam(value = "userRole",required = false) Integer userRole,
                                    @RequestParam(value ="currentPage",defaultValue = "1")Integer currentPage,
                                    @RequestParam(value ="pageSize",required = false)Integer pageSize){

        MyPage myPage = new MyPage(currentPage, pageSize);

        return userService.selectPage(userName,userRole,myPage);
    }




    //查询用户数量
    @RequestMapping("/getUserCount")
    public int getUserCount(@RequestParam(value = "userName",defaultValue = "") String userName, @RequestParam(value = "userRole",required = false) Integer userRole){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (!userName.equals("")){
            wrapper.like("userName",userName);
        }
        if (userRole != null){
            wrapper.eq("userRole",userRole);
        }
        return userService.count(wrapper);
    }
    //增加用户
    @RequestMapping("/add")
    public String add(User user)
    {
        user.setCreationDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        userService.save(user);
        return "添加成功！";
    }

    //删除用户
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        userService.removeById(id);
        return "删除成功！";
    }

    //修改用户
    @RequestMapping("/modify")
    public String modify(User user){
        user.setModifyDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",user.getId());
        userService.update(user,wrapper);
        return "修改成功！";
    }
}
