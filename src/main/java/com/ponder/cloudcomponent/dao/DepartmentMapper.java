package com.ponder.cloudcomponent.dao;

import com.ponder.cloudcomponent.model.po.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {

    List<Department> list();

    Department detail(String deptNo);
}