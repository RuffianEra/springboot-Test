package com.example.springboot01cache.cache.service;

import com.example.springboot01cache.cache.bean.Employee;
import com.example.springboot01cache.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@CacheConfig(keyGenerator = "myKeyGenerator")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = "amp")
    public Employee getAmpById(int id){
        System.out.println("amp------查询" + id + "号员工------");
        return employeeMapper.getEmployeeById(id);
    }
    @CachePut(cacheNames = "bmp")
    public Employee getBmpById(int id){
        System.out.println("bmp------查询" + id + "号员工------");
        return employeeMapper.getEmployeeById(id);
    }

    @CacheEvict(cacheNames = "amp", allEntries = true)
    public void delectAmp(){
        System.out.println("删除所有缓存");
    }
}