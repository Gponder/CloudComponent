package com.ponder.cloudcomponent.model.po;

import lombok.Data;

import java.sql.Date;


/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/16 15:57
 */
@Data
public class Employee {

    private Integer emp_no;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;

}
