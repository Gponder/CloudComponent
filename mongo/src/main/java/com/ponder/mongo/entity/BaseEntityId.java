package com.ponder.mongo.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/30 11:01
 */
@Data
public class BaseEntityId {
    @Id
    private ObjectId id;
}
