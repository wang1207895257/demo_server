package com.example.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUserVO implements Serializable {

    private String id;
    private String userName;
    private String identityCode;
    private String identityCodeType;
    private Date createTime;
    private Date updateTime;
}
