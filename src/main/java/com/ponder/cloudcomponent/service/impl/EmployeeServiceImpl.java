package com.ponder.cloudcomponent.service.impl;

import com.ponder.cloudcomponent.dao.EmployeeMapper;
import com.ponder.cloudcomponent.model.po.Employee;
import com.ponder.cloudcomponent.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/16 16:07
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> list() {
        return employeeMapper.list();
    }



}
