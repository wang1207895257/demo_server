package com.example.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@TableName("sys_user")
public class SysUser implements Serializable {

    // @TableId(value = "id", type = IdType.AUTO)
    // private String id;
    // @TableField("user_name")
    // private String userName;
    // @TableField("identity_code")
    // private String identityCode;
    // @TableField("identity_code_type")
    // private String identityCodeType;
    // @TableField("create_time")
    // private Date createTime;
    // @TableField("update_time")
    // private Date updateTime;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    @TableField("user_name")
    private String user_name;
    @TableField("identity_code")
    private String identity_code;
    @TableField("identity_code_type")
    private Integer identity_code_type;
    @TableField("create_time")
    private Date create_time;
    @TableField("update_time")
    private Date update_time;
}
