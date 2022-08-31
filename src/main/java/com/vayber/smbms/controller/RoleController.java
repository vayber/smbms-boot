package com.vayber.smbms.controller;

import com.vayber.smbms.bean.Role;
import com.vayber.smbms.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    //获取角色列表
    @RequestMapping("/queryList")
    public List<Role> getRoleList(){
        return roleService.list();
    }
}
