package com.ujiuye.mapper;

import com.ujiuye.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    /**
     * 通过用户查询员工
     * @param username  用户名，唯一
     * @return 员工对象
     */
    Employee getByUserName(String username);
    List<Employee> list(@Param("username") String username, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
    int save(Employee employee);
}
