package com.example.springboot01cache.cachea.service;

import com.example.springboot01cache.cachea.bean.Employee;
import com.example.springboot01cache.cachea.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = "emp")
    public Employee getEmployeeById(int id){
        System.out.println("------查询" + id + "号员工------");
        return employeeMapper.getEmployeeById(id);
    }

    public void updateEmployee(Employee employee){
        System.out.println("------修改" + employee.getId() + "号员工------");
        employeeMapper.updateEmployeeById(employee);
    }

    public void deleteEmployeeById(int id){
        System.out.println("------删除" + id + "号员工------");
        employeeMapper.delectEmployeeById(id);
    }

    public void insertEmployee(Employee employee){
        System.out.println("------添加员工------");
        employeeMapper.insertEmployee(employee);
    }
}
