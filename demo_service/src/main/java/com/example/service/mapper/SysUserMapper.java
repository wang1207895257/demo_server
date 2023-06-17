package com.example.service.mapper;

import com.example.model.po.SysUser;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// @Mapper
public interface SysUserMapper {

    @Select("select * from sys_user")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "identityCode", column = "identity_code"),
            @Result(property = "identityCodeType", column = "identity_code_type"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    public List<SysUser> getUsers();
}
