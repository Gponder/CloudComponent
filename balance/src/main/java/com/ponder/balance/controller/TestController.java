package com.ponder.balance.controller;

import com.ponder.balance.api.EmployeeApi;
import com.ponder.balance.api.EmployeeApi2;
import com.ponder.cloudcomponent.model.po.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/13 16:51
 */
@RestController
@RequestMapping("test")
public class TestController {

//    @Autowired
//    private EmployeeApi employeeApi;

    @Autowired
    private EmployeeApi2 employeeApi2;

    @GetMapping("getData")
    public List<Employee> getFromData(){
        return employeeApi2.list();//employeeApi.list();
    }



}
