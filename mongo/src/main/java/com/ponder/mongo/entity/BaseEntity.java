package com.ponder.mongo.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/30 9:23
 */
@Data
public class BaseEntity {

    @Id
    private String id;

    public Date getDate(){
        return new ObjectId(id).getDate();
    }

    public int getTimestamp(){
        return new ObjectId(id).getTimestamp();
    }

}
