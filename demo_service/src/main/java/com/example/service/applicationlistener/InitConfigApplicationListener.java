package com.example.service.applicationlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author wangzf-c
 * @date 2023/11/26
 */
// @Component
@Slf4j
public class InitConfigApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        log.error("testinit: ApplicationListener启动! ");
    }
}
