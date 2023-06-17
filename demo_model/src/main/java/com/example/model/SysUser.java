package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUser implements Serializable {

    private String id;
    private String userName;
    private String identityCode;
    private String identityCodeType;
    private Date createTime;
    private Date updateTime;
}
