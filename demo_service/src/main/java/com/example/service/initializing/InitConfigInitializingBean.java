package com.example.service.initializing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author wangzf-c
 * @date 2023/11/26
 */
// @Component
@Slf4j
public class InitConfigInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.error("testinit: InitializingBean已启动! ");
    }
}
