package com.ponder.datajpa.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/16 9:08
 */
@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tId;

    private String tName;

    private String tGender;

    private Date tBirthday;

}
