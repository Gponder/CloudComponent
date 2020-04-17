package com.ponder.cloudcomponent.service.impl;

import com.ponder.cloudcomponent.dao.DepartmentMapper;
import com.ponder.cloudcomponent.model.po.Department;
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

    private final DepartmentMapper departmentMapper;

    /**
     * 依赖注入有三种方式：
     *
     * 变量（filed）注入      waring"Field injection is not recommended"(idea 会提示变量注入是不推荐的)
     * 构造器注入        （强制依赖）
     * set方法注入      （选择依赖）常用于配置
     * @param departmentMapper
     */
    @Autowired
    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<Department> list() {
        return departmentMapper.list();
    }

    @Override
    public Department detail(String deptNo){
        return departmentMapper.detail(deptNo);
    }
}
