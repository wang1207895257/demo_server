package com.example.service.service.impl;

import com.example.model.SysUser;
import com.example.service.mapper.ServiceMapper;
import com.example.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements IServiceService {

    @Autowired
    private ServiceMapper mapper;
    public List<SysUser> getUsers() {
        return mapper.getUsers();
    }
}
