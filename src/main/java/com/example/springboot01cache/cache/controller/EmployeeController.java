package com.example.springboot01cache.cache.controller;

import com.example.springboot01cache.cache.bean.Employee;
import com.example.springboot01cache.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/amp/{id}")
    public Employee getEmployee1(@PathVariable("id") int id){
        return employeeService.getAmpById(id);
    }
    @RequestMapping("/bmp/{id}")
    public Employee getEmployee2(@PathVariable("id") int id){
        return employeeService.getBmpById(id);
    }

    @RequestMapping("/delAmp")
    public void getEmployee99(){
        employeeService.delectAmp();
    }
}