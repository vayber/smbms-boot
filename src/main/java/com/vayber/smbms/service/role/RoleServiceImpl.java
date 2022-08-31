package com.vayber.smbms.service.role;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vayber.smbms.bean.Role;
import com.vayber.smbms.mapper.RoleMapper;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService{
}
