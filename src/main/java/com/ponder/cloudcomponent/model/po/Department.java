package com.ponder.cloudcomponent.model.po;

import lombok.Data;

import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/15 19:21
 */
@Data
public class Department {
    private String deptNo;
    private String deptName;

    private List<DeptEmp> deptEmployees;
}
