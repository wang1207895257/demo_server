package com.example.service.postconstruct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author wangzf-c
 * @date 2023/11/26
 */
// @Component
@Slf4j
public class InitConfigPostConstruct {

    @PostConstruct
    public void init() {
        log.error("testinit: postconstruct已启动! ");
    }
}
