package com.example.app.service;

import com.example.model.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// @FeignClient(value = "service", url = "http://localhost:8082")
@FeignClient(value = "demo-service")
public interface IAppService {

    @GetMapping("serviceController/demo")
    public String getService();

    @GetMapping("serviceController/demo1")
    public void getService1();

    @GetMapping("serviceController/getUser")
    List<SysUser> getUser();
}
