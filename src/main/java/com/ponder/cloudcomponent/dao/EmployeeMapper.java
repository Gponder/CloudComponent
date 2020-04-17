package com.ponder.cloudcomponent.dao;

import com.ponder.cloudcomponent.model.po.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/16 15:57
 */
@Repository
public interface EmployeeMapper {

    List<Employee> list();

    Employee getByEmpNo(Integer empNo);

}
