package com.ponder.datajpa.repository;

import com.ponder.datajpa.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/16 9:08
 */
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    @Transactional
    @Modifying
    @Query("update Teacher set tName = ?2 where tId = ?1")
    Integer updateTNameByTID(Integer tId,String tName);

    Teacher findBytName(String tName);

    @Query("select t from Teacher t where t.tGender = ?1")
    Page<Teacher> findBytGender(String gender, Pageable pageable);
}
