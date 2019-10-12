package com.example.springboot01cache.mq.activeMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/*@Configuration*/
@Service
public class Production {

    @Autowired
    JmsTemplate jmsTemplate;

    /*@Bean
    public CommandLineRunner getCommandLineRunner(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

            }
        };
    }*/

    public void send(String aisle, String message){
        System.out.println("发送 \"" + message + "\" 到 \"" + aisle + "\" 通道中");
        jmsTemplate.convertAndSend(aisle, message);
    }
}
