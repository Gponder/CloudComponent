package com.ponder.cloudcomponent.controller;

import com.ponder.cloudcomponent.model.po.Departments;
import com.ponder.cloudcomponent.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/14 20:35
 */
@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Departments> auth(){
        List<Departments> list = departmentService.list();
        return list;
    }
}
