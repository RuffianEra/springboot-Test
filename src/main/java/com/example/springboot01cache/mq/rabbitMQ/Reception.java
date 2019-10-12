package com.example.springboot01cache.mq.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Reception {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "direct_queue")
    public void directQueue(String message){
        System.out.println("监听direct_queue队列，获取到" + message);
    }

    @RabbitListener(queues = "fanout_queue")
    public void fanoutQueue(String message){
        System.out.println("监听fanout_queue队列，获取到" + message);
    }

    @RabbitListener(queues = "queue_fanout")
    public void queueFanout(String message){
        System.out.println("监听queue_fanout队列，获取到" + message);
    }

    @RabbitListener(queues = "topic_queue")
    public void topicQueue(String message){
        System.out.println("监听topic_queue队列，获取到" + message);
    }
}
