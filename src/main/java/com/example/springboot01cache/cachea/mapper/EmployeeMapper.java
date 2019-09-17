package com.example.springboot01cache.cachea.mapper;

import com.example.springboot01cache.cachea.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    public Employee getEmployeeById(int id);

    @Update("update employee set last_name=#{lastName}, email=#{email}, gender=#{gender}, d_id=#{dId}")
    public void updateEmployeeById(Employee employee);

    @Delete("delect employee where id=#{id}")
    public void delectEmployeeById(int id);

    @Insert("insert init employee (id, lastName, email, gender, dId) value (#{id}, #{lastName}, #{email}, #{gender}, #{dId})")
    public void insertEmployee(Employee employee);
}
