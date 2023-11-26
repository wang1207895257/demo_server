package com.example.service.applicationrunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/**
 * @author wangzf-c
 * @date 2023/11/26
 */
// @Component
public class InitConfigApplicationRunner implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitConfigApplicationRunner.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.error("testinit: ApplicationRunner已启动! ");
    }
}
