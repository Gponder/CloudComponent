package com.ponder.cloudcomponent.dao;

import com.ponder.cloudcomponent.model.po.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/17 17:52
 */
@Repository
public interface DeptEmpMapper {

    List<Employee> departmentEmployee(String deptNo);

}
