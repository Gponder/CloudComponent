package com.ponder.datajpa.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/15 10:28
 */
@Data
@Entity
@Table(name = "student")
public class Student {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private Integer id;

    @Column(name = "s_birthday")
    private Date birthday;

    @Column(name = "s_gender")
    private Integer gender;

    @Column(name = "s_name")
    private String name;

}
