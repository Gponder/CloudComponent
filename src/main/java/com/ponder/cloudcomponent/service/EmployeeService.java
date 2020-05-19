package com.ponder.cloudcomponent.service;

import com.ponder.cloudcomponent.model.po.Employee;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/16 16:07
 */
public interface EmployeeService {
    //@GetMapping("/employee/list")
    List<Employee> list();
}
