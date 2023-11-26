package com.example.service.commandrunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author wangzf-c
 * @date 2023/11/26
 */
// @Component
public class InitConfigCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitConfigCommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.error("testinit: commandLineRunner已启动");
    }
}