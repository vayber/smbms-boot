package com.vayber.smbms.bean;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Date;


@Data
@Repository
@TableName("smbms_user")
public class User {
        @TableId(type = IdType.AUTO)
        private Integer id;
        private String userCode;
        private String userName;
        private String userPassword;
        private Integer gender;
        private Date birthday;

        private String phone;
        private String address;
        private Integer userRole;

        @TableField(exist = false)
        private String UserRoleName;

        private Integer createdBy;
        private String creationDate;
        private Integer modifyBy;
        private String modifyDate;
        private Integer age;

}

