package com.ponder.cloudcomponent.model.po;

import lombok.Data;

import java.sql.Date;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/17 17:53
 */
@Data
public class DeptEmp {
    private Integer empNo;
    private String deptNo;
    private Date fromDate;
    private Date toDate;

    private Employee employee;
}
