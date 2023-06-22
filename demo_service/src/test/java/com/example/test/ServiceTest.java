package com.example.test;

import com.alibaba.fastjson.JSON;
import com.example.model.po.SysUser;
import com.example.model.vo.SysUserVO;
import com.example.util.BeanCovertUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceTest {

    @Test
    public void testDemo() {
        SysUser user = new SysUser();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setUserName("wzf");
        user.setIdentityCode("wzf");
        user.setIdentityCodeType("1");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        SysUserVO sysUserVO = BeanCovertUtils.covertTo(user, SysUserVO::new);
        SysUserVO sysUserVO1 = BeanCovertUtils.deepCovertTo(user, SysUserVO.class);
        System.err.println(JSON.toJSONString(sysUserVO));
        System.err.println(JSON.toJSONString(sysUserVO1));
    }

    @Test
    public void testListDemo() {
        List<SysUser> sysUserList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            SysUser user = new SysUser();
            user.setId(UUID.randomUUID().toString().replace("-", ""));
            user.setUserName("wzf" + i);
            user.setIdentityCode("wzf" + i);
            user.setIdentityCodeType("1");
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            sysUserList.add(user);
        }

        List<SysUserVO> sysUserVOS = BeanCovertUtils.covertListTo(sysUserList, SysUserVO::new);
        List<SysUserVO> sysUserVOS1 = BeanCovertUtils.deepCovertListTo(sysUserList, SysUserVO.class);
        System.err.println(JSON.toJSONString(sysUserVOS));
        System.err.println(JSON.toJSONString(sysUserVOS1));
    }
}
