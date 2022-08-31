package com.vayber.smbms.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vayber.smbms.bean.MyPage;
import com.vayber.smbms.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> getUserList( String userName, Integer userRole);

    List<User>  selectPage( String userName, Integer userRole, @Param("myPage") MyPage myPage);

}
