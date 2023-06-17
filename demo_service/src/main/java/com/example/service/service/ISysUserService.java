package com.example.service.service;

import com.example.model.po.SysUser;

import java.util.List;

public interface ISysUserService {

    public List<SysUser> getUsers();

    public void saveUser();
}
