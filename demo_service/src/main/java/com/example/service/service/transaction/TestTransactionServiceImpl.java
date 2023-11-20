package com.example.service.service.transaction;

import com.example.model.po.SysUser;
import com.example.model.service.ISysUserDataService;
import com.example.service.service.transaction.impl.ITestTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author wangzf-c
 * @date 2023/11/25
 */
@Service
public class TestTransactionServiceImpl implements ITestTransactionService {

    @Autowired
    private ISysUserDataService service;
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    // @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void testTransaction() {
        SysUser user = new SysUser();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setUserName("user_main");
        user.setIdentityCode("111");
        user.setIdentityCodeType("111");
        user.setCreateTime(new Date());
        service.save(user);
        ITestTransactionService bean = applicationContext.getBean(ITestTransactionService.class);
        bean.saveTwoUser();
    }

    @Override
    public void saveTwoUser() {
        SysUser user = new SysUser();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setUserName("user_main");
        user.setIdentityCode("111");
        user.setIdentityCodeType("111");
        user.setCreateTime(new Date());
        service.save(user);
        if (true) {
            throw new RuntimeException("保存用户异常");
        }
    }
}
