package com.example.service.service.postconstruct;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangzf-c
 * @date 2023/11/20
 */
// @Component
public class TestPostConstruct {

    private static final ScheduledExecutorService executor =
            new ScheduledThreadPoolExecutor(1, Executors.defaultThreadFactory());
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @PostConstruct
    public void test() {
        System.err.printf("【%s】新建任务%n" , df.format(new Date()));
        executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.err.printf("【%s】大家注意了，我要发消息了%n" , df.format(new Date()));
            }
        }, 1, 2, TimeUnit.SECONDS);
    }
}
