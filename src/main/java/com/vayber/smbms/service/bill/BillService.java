package com.vayber.smbms.service.bill;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vayber.smbms.bean.Bill;
import com.vayber.smbms.bean.MyPage;


import java.util.List;

public interface BillService extends IService<Bill> {
    List<Bill> getBillList(String productName,Integer providerId,Integer isPayment);

    List<Bill>  selectPage(String productName,Integer providerId,Integer isPayment, MyPage myPage);
}
