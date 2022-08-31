package com.vayber.smbms.service.provider;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vayber.smbms.bean.Provider;
import com.vayber.smbms.mapper.ProviderMapper;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl extends ServiceImpl<ProviderMapper, Provider> implements ProviderService{
}
