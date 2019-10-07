package com.example.springboot01cache.cache.service;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
public class EmpKeyGenerator{
    @Bean("myKeyGenerator")
    public KeyGenerator getKeyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName() + "_" + Arrays.asList(objects).get(0);
            }
        };
    }
}
