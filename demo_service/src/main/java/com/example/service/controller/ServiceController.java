package com.example.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("serviceController")
@RestController
public class ServiceController {

    @GetMapping("demo")
    public String getDemo() {
        return "service-controller";
    }

    @GetMapping("demo1")
    public void getDemo1() {
        System.err.println("service-controller");
    }
}
