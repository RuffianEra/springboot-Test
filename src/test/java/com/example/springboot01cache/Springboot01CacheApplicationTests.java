package com.example.springboot01cache;

import com.example.springboot01cache.cachea.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

    @Autowired()
    EmployeeMapper employeeMapper;

    @Test
    public void contextLoads() {
        System.out.println(employeeMapper.getEmployeeById(1));
    }

}
