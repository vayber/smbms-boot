package com.vayber.smbms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.vayber.smbms.bean.Bill;

import com.vayber.smbms.bean.MyPage;
import com.vayber.smbms.service.bill.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService billService;

    //通过条件查询获取账单列表
    @Deprecated
    @RequestMapping("/queryList")
    public List<Bill> getBillList(@RequestParam(value = "productName",defaultValue = "")String productName,
                                  @RequestParam(value = "providerId",required = false)Integer providerId ,
                                  @RequestParam(value = "isPayment",required = false)Integer isPayment){

        return billService.getBillList(productName,providerId,isPayment);

    }

    //通过条件查询获取账单分页列表
    @RequestMapping("/queryPageList")
    public List<Bill> getBillPageList(@RequestParam(value = "productName",defaultValue = "")String productName,
                                  @RequestParam(value = "providerId",required = false)Integer providerId ,
                                  @RequestParam(value = "isPayment",required = false)Integer isPayment,
                                  @RequestParam(value ="currentPage",defaultValue = "1")Integer currentPage,
                                  @RequestParam(value ="pageSize",required = false)Integer pageSize){


        MyPage myPage = new MyPage(currentPage, pageSize);

        return billService.selectPage(productName,providerId,isPayment,myPage);

    }


    //获取商品数量(根据商品名或者供应商或者是否付款)
    @RequestMapping("/getBillCount")
    public int getBillCount(@RequestParam(value = "productName",defaultValue = "")String productName,
                                  @RequestParam(value = "providerId",defaultValue = "")Integer providerId ,
                            @RequestParam(value = "isPayment",required = false)Integer isPayment){

        QueryWrapper<Bill> wrapper = new QueryWrapper<>();


        if (providerId != null){
            wrapper.eq("providerId",providerId);
        }
        if (!"".equals(productName)){
            wrapper.like("productName",productName);
        }
        if (isPayment != null){
            wrapper.eq("isPayment",isPayment);
        }
        return billService.count(wrapper);

    }


    //添加订单
    @RequestMapping("/add")
    public String add(Bill bill){

        bill.setCreationDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        billService.save(bill);
        return "添加成功！";
    }

    //删除订单
    @RequestMapping("/delete")
    public String delete(@RequestParam("id")Integer id){
        billService.removeById(id);
        return "删除成功！";
    }

    //修改订单
    @RequestMapping("/modify")
    public String modify(Bill bill){
        bill.setModifyDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        UpdateWrapper<Bill> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",bill.getId());
        billService.update(bill,wrapper);
        return "修改成功！";
    }

}
