package com.vayber.smbms.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
@TableName("smbms_bill")
public class Bill {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String billCode;
    private String productName; //商品名称
    private String productDesc; //商品描述
    private String productUnit; //商品单位
    private String productCount;
    private String totalPrice;
    private Integer isPayment;      //是否支付   1      2
    private Integer createdBy;
    private String creationDate;
    private Integer modifyBy;
    private String modifyDate;

    private Integer providerId;
    @TableField(exist = false)
    private String proName;

}
