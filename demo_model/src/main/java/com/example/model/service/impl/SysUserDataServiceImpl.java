package com.example.model.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.model.mapper.SysUserDataMapper;
import com.example.model.po.SysUser;
import com.example.model.service.ISysUserDataService;
import org.springframework.stereotype.Service;

@Service
public class SysUserDataServiceImpl extends ServiceImpl<SysUserDataMapper, SysUser> implements ISysUserDataService {
}
