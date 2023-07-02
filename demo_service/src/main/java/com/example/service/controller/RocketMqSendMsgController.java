package com.example.service.controller;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("sendMq")
@RestController
public class RocketMqSendMsgController {

    @GetMapping("sendMsg")
    public void sendMsg() {
        try {
            DefaultMQProducer producer = new DefaultMQProducer("first");
            // 设置nameServer地址
            producer.setNamesrvAddr("127.0.0.1:9876");
            producer.start();

            //发送topic信息
            Message msg1 = new Message("myTopic", "first 第一条".getBytes());
            Message msg2 = new Message("myTopic", "first 第二条".getBytes());
            Message msg3 = new Message("myTopic", "first 第三条".getBytes());

            //同步发送消息
            SendResult send1 = producer.send(msg1);
            SendResult send2 = producer.send(msg2);
            SendResult send3 = producer.send(msg3);

            System.err.println(send1);
            System.err.println(send2);
            System.err.println(send3);

            producer.shutdown();
            System.err.println("shut down");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
