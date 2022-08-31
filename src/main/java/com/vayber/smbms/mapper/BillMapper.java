package com.vayber.smbms.mapper;





import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vayber.smbms.bean.Bill;
import com.vayber.smbms.bean.MyPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface BillMapper extends BaseMapper<Bill> {

    List<Bill> getBillList(String productName,Integer providerId,Integer isPayment);
    List<Bill>  selectPage(String productName,Integer providerId,Integer isPayment,@Param("myPage") MyPage myPage);
}
