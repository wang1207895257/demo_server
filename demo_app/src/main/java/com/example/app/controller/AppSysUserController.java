package com.example.app.controller;


import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.example.app.service.RISysUserService;
import com.example.model.SysUser;
import com.example.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Properties;

@RequestMapping("appUserController")
@RestController
public class AppSysUserController {

    @Autowired
    private RISysUserService appService;

    @GetMapping("voiddemo")
    public void getVoidDemo() {
        appService.getService1();
    }

    @GetMapping("voiddemo2")
    public void getVoidDemo2() {
        String url = "http://localhost:181/serviceController/demo1";
        String result= HttpUtil.doGet(url);
        System.err.println(result);
    }

    @GetMapping("getUser")
    public List<SysUser> getUser() {
        return appService.getUsers();
    }

    public static void main(String[] args) {
        try {
            String nacosAddress = "127.0.0.1:8848";
            String dataId = "app.properties";
            String group = "DEFAULT_GROUP";
            Properties properties = new Properties();
            properties.put("serverAddr", nacosAddress);
            ConfigService configService = NacosFactory.createConfigService(properties);
            String config = configService.getConfig(dataId, group, 5000);
            System.err.println(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
