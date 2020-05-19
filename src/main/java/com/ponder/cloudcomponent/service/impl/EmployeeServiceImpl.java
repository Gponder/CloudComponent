package com.ponder.cloudcomponent.service.impl;

import com.ponder.cloudcomponent.dao.EmployeeMapper;
import com.ponder.cloudcomponent.model.po.Employee;
import com.ponder.cloudcomponent.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/16 16:07
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    Logger logger = LoggerFactory.getLogger("employeeMapper");

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> list() {
        InetAddress inetAddress = null;
        try {
             inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        logger.info(new StringBuilder()
                .append("localhost:")
                .append(inetAddress.getHostName())
                .append("-")
                .append(inetAddress.getHostAddress())
                .toString());
        return employeeMapper.list();
    }



}
