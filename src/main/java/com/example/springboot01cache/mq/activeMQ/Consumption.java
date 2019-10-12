package com.example.springboot01cache.mq.activeMQ;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

public class Consumption {

    @JmsListener(destination = "aisle")
    public void amp(String message){
        System.out.println("aisle_______" + message);
    }

    @JmsListener(destination = "test")
    public void bmp(String message){
        System.out.println("test_______" + message);
    }
}