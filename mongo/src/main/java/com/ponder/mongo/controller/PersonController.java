package com.ponder.mongo.controller;

import com.mongodb.client.*;
import com.ponder.mongo.entity.Person;
import com.ponder.mongo.repository.PersonRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/29 14:58
 */
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("add")
    public String addPerson(Person person){
        personRepository.insert(person);
        return "success";
    }

    @GetMapping("/{id}")
    public List<Person> getPerson(@PathVariable String id){
        return personRepository.findAll();
    }

    /**
     * 原生操作
     * @return
     */
    private List<Document> test(){
        MongoClient mongoClient = MongoClients.create( );
        MongoDatabase test = mongoClient.getDatabase("test");
        MongoCollection<Document> persons = test.getCollection("person");
        Document person = new Document().append("name", "gao")
                .append("gender","male")
                .append("id",1);
        persons.insertOne(person);
        FindIterable<Document> documents = persons.find();
        MongoCursor<Document> it = documents.iterator();
        List<Document> result = new ArrayList<>();
        while (it.hasNext()){
            Document doc = it.next();
            result.add(doc);
        }
        return result;
    }
}
