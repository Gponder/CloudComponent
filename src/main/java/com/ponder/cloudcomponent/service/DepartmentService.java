package com.ponder.cloudcomponent.service;

import com.ponder.cloudcomponent.model.po.Department;

import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/15 19:24
 */
public interface DepartmentService {

    List<Department> list();

    Department detail(String deptNo);
}
