package com.example.service.controller;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("reviceMq")
@RestController
public class RocketMqReviceNsgController {

    @GetMapping("reviceMsg")
    public void reviceMsg() {

        try {
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("firstConsumer");
            consumer.setNamesrvAddr("127.0.0.1:9876");

            consumer.subscribe("myTopic", "*");

            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    for (MessageExt messageExt : list) {
                        System.err.println(new String(messageExt.getBody()));
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.setMessageModel(MessageModel.CLUSTERING);
            consumer.start();
            System.out.println("Consumer 01 start...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
