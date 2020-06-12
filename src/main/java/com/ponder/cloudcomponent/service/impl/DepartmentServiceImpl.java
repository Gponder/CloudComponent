package com.ponder.cloudcomponent.service.impl;

import com.ponder.cloudcomponent.dao.DepartmentMapper;
import com.ponder.cloudcomponent.model.po.Department;
import com.ponder.cloudcomponent.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 非事务方法调用内部带事务方法会造成事务失效 事务实现基于aop 依赖代理类开启事务，
     * 内部调用时不经过代理类，需要在调用方法上开启事务或者通过代理类调用不同对象带事务方法即可生效
     * @param department
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    @Override
    public void save(Department department) {
        departmentMapper.save(department);
    }

}
