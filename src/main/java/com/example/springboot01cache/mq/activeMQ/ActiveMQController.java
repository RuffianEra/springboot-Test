package com.example.springboot01cache.mq.activeMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActiveMQController {

    @Autowired
    Production production;
    @RequestMapping("/{aisle}/{message}")
    public void activeSend(@PathVariable("aisle")String aisle, @PathVariable("message")String message){
        production.send(aisle, message);
    }
}