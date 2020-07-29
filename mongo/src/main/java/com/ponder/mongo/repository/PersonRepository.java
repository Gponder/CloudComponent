package com.ponder.mongo.repository;

import com.ponder.mongo.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/29 14:56
 */
@Repository
public interface PersonRepository extends MongoRepository<Person,String> {
}
