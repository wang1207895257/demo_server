package com.example.service.service.impl;

import com.example.model.po.SysUser;
import com.example.model.service.ISysUserDataService;
import com.example.model.vo.SysUserVO;
import com.example.service.mapper.SysUserMapper;
import com.example.service.service.ISysUserService;
import com.example.util.BeanCovertUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper mapper;

    @Autowired
    private ISysUserDataService service;
    public List<SysUser> getUsers() {
        return mapper.getUsers();
    }

    public void saveUser() {
        List<SysUser> sysUsers = Lists.newArrayList();
        try {
            for (int i = 0; i < 10; i++) {
                SysUser user = new SysUser();
                user.setId(UUID.randomUUID().toString().replace("-", ""));
                user.setUserName("wzf" + i);
                user.setIdentityCode("wzf" + i);
                user.setIdentityCodeType("1");
                user.setCreateTime(new Date());
                user.setUpdateTime(new Date());
                service.save(user);
                // sysUsers.add(user);
            }
            // service.saveBatch(sysUsers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void testConvert() {
        SysUser user = new SysUser();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setUserName("wzf");
        user.setIdentityCode("wzf");
        user.setIdentityCodeType("1");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        SysUserVO sysUserVO = BeanCovertUtils.covertTo(user, SysUserVO::new);
        System.err.println(sysUserVO);
    }
}
