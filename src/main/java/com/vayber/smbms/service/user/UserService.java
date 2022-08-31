package com.vayber.smbms.service.user;


import com.baomidou.mybatisplus.extension.service.IService;
import com.vayber.smbms.bean.MyPage;
import com.vayber.smbms.bean.User;


import java.util.List;

public interface UserService extends IService<User> {
    List<User> getUserList(String userName,Integer userRole);

    List<User>  selectPage(String userName,Integer userRole, MyPage myPage);


}
