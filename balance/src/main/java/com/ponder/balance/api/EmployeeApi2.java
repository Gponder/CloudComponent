package com.ponder.balance.api;

import com.ponder.cloudcomponent.model.po.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/18 20:40
 */
@FeignClient("cloud-component")
public interface EmployeeApi2 {
    @GetMapping("/employee/list")
    List<Employee> list();
}
