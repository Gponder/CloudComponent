package com.ponder.cloudcomponent.service.impl;

import com.ponder.cloudcomponent.dao.DepartmentsMapper;
import com.ponder.cloudcomponent.model.po.Departments;
import com.ponder.cloudcomponent.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/15 19:25
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentsMapper departmentsMapper;

    @Override
    public List<Departments> list() {
        return departmentsMapper.list();
    }
}
