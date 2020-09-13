package com.ujiuye.service;

import com.ujiuye.mapper.EmployeeMapper;
import com.ujiuye.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getByUserName(String username) {
        return employeeMapper.getByUserName(username);
    }

    @Override
    public List<Employee> list(String username, Date beginTime, Date endTime) {
        return employeeMapper.list(username,beginTime,endTime);
    }

    @Override
    public int save(Employee employee) {
        employee.setHiredate(new Date());
        employee.setCreatetime(new Date());
        employee.setState(1);
        return employeeMapper.save(employee);
    }
}
