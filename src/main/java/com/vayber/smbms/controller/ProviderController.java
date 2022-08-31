package com.vayber.smbms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vayber.smbms.bean.Provider;
import com.vayber.smbms.service.provider.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    ProviderService providerService;

    //获取供应商列表 用于新增账单选择供应商
    @RequestMapping("/queryList")
    public List<Provider> queryList(){

        return providerService.list();
    }

    //获取供应商分页列表(根据供应商编码或者供应商名称)
    @RequestMapping("/queryPageList")
    public List<Provider> queryPageList(@RequestParam(value = "proCode",defaultValue = "") String proCode,
                                        @RequestParam(value = "proName",defaultValue = "") String proName,
                                        @RequestParam(value ="currentPage",defaultValue = "1")Integer currentPage,
                                        @RequestParam(value ="pageSize",required = false)Integer pageSize){

        Page<Provider> page = new Page<>(currentPage,pageSize);

        QueryWrapper<Provider> wrapper = new QueryWrapper<>();
        if (!proCode.equals("")){
            wrapper.like("proCode",proCode);
        }
        if (!proName.equals("")){
            wrapper.eq("userRole",proName);
        }

        Page<Provider> providerPage = providerService.page(page,wrapper);

        List<Provider> records = providerPage.getRecords();   //当前页记录

        return records;
    }

    //获取供应商总数(根据供应商编码或者供应商名称)
    @RequestMapping("/getProviderCount")
    public int getProviderCount(@RequestParam(value = "proCode",defaultValue = "") String proCode, @RequestParam(value = "proName",defaultValue = "") String proName){
        QueryWrapper<Provider> wrapper = new QueryWrapper<>();
        if (!proCode.equals("")){
            wrapper.like("proCode",proCode);
        }
        if (!proName.equals("")){
            wrapper.eq("userRole",proName);
        }
        return providerService.count(wrapper);
    }



    //添加供应商
    @RequestMapping("/add")
    public String add(Provider provider)
    {
        provider.setCreationDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        providerService.save(provider);
        return "添加成功！";
    }

    //删除供应商
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        providerService.removeById(id);
        return "删除成功！";
    }


    //修改供应商
    @RequestMapping("/modify")
    public String modify(Provider provider){
        provider.setModifyDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        UpdateWrapper<Provider> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",provider.getId());
        providerService.update(provider,wrapper);
        return "修改成功！";
    }
}
