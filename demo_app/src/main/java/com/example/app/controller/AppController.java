package com.example.app.controller;


import com.example.app.service.IAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("appController")
@RestController
public class AppController {

    @Autowired
    private IAppService appService;

    @GetMapping("demo")
    public String getDemo() {
        return appService.getService();
    }

    @GetMapping("voiddemo")
    public void getVoidDemo() {
        appService.getService1();
    }
}
