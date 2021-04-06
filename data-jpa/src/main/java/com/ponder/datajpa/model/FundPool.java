package com.ponder.datajpa.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/11/30 15:04
 */
@Data
@Entity
@Table(name = "t_fundpool")
public class FundPool {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String business_id;

    private String business_name;

    private String business_type;

    private Double remain_amount;

    private Integer fund_type;

    private String remark;

    private Date start_time;

    private Timestamp add_time;

    private Integer status;

}
