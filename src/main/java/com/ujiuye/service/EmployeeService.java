package com.ujiuye.service;

import com.ujiuye.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    /**
     * 通过用户查询员工
     * @param username  用户名，唯一
     * @return 员工对象
     */
    Employee getByUserName(String username);

    List<Employee> list(String username, Date beginTime, Date endTime);
    int save(Employee employee);
}
