package com.ponder.balance.api;

import com.ponder.cloudcomponent.service.EmployeeService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/18 17:19
 *
 * 同一个微服务只能注册一次
 * 如果使用继承需要在被继承的接口中添加注释 请求方法请求路径 如：@GetMapping
 * tips：其实feign访问只需要被访问服务器微服务注册即可，继承只是便于管理不同于dubbo provider consumer必须继承同意接口
 *
 * 也可以直接写接口+注释 访问地址为：微服务名/注释访问地址
 */
//@FeignClient("cloud-component")
public interface EmployeeApi extends EmployeeService {

}
