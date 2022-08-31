package com.vayber.smbms.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
@TableName("smbms_provider")
public class Provider {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String proCode;
    private String proName;
    private String proDesc;
    private String proContact;  //供应联系人
    private String proPhone;
    private String proAddress;
    private String proFax;  //传真
    private Integer createdBy;
    private String creationDate;
    private String modifyDate;
    private Integer modifyBy;


}
