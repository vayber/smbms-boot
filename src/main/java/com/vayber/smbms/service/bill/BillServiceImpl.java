package com.vayber.smbms.service.bill;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vayber.smbms.bean.Bill;
import com.vayber.smbms.bean.MyPage;
import com.vayber.smbms.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl extends ServiceImpl<BillMapper,Bill> implements BillService {

    @Autowired
    BillMapper billMapper;

    @Override
    public List<Bill> getBillList(String productName,Integer providerId,Integer isPayment) {
        return billMapper.getBillList(productName,providerId,isPayment);
    }

    @Override
    public List<Bill> selectPage(String productName, Integer providerId, Integer isPayment, MyPage myPage) {
        return billMapper.selectPage(productName,providerId,isPayment,myPage);
    }


}
