package com.ponder.cloudcomponent.dao;

import com.ponder.cloudcomponent.model.po.Departments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsMapper {

    List<Departments> list();

}