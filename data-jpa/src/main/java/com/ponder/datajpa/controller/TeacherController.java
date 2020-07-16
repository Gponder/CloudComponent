package com.ponder.datajpa.controller;

import com.ponder.datajpa.model.Teacher;
import com.ponder.datajpa.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/16 9:26
 */
@RestController
@RequestMapping("Teacher")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("list")
    public List<Teacher> list(){
        return teacherRepository.findAll();
    }

    @GetMapping("get")
    public Teacher get(Teacher teacher){
        return teacherRepository.getOne(teacher.getTId());
    }

    @GetMapping("updateName")
    public Integer updateName(String name,Integer id){
        return teacherRepository.updateTNameByTID(id,name);
    }
}
