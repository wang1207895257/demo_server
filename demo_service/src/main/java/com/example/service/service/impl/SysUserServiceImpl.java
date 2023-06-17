package com.example.service.service.impl;

import com.example.model.po.SysUser;
import com.example.service.mapper.SysUserMapper;
import com.example.service.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper mapper;
    public List<SysUser> getUsers() {
        return mapper.getUsers();
    }
}
