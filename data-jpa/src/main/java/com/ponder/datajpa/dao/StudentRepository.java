package com.ponder.datajpa.dao;

import com.ponder.datajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/15 11:40
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
