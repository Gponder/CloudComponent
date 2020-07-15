package com.ponder.datajpa.controller;

import com.ponder.datajpa.dao.StudentRepository;
import com.ponder.datajpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/15 11:44
 */
@RequestMapping("Student")
@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("get")
    public Student get(Student student){
        return studentRepository.getOne(student.getId());
    }

    @GetMapping("list")
    public List<Student> list(){
        return studentRepository.findAll();
    }

    @PostMapping("add")
    public Student add(Student student){
        return studentRepository.save(student);
    }

    @PostMapping("update")
    public Student update(Student student){
        return studentRepository.save(student);
    }
}
