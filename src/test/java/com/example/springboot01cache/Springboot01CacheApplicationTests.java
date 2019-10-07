package com.example.springboot01cache;

import com.example.springboot01cache.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

    /* 数据库实体类 */
    @Autowired()
    EmployeeMapper employeeMapper;
    @Test
    public void mybatisTest(){
        System.out.println(employeeMapper.getEmployeeById(2));
    }

    /* 缓存测试 */
    //@Autowired




}
