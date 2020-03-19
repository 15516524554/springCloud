package com.cetc.springcloud.service;

import com.cetc.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
//@FeignClient(value = "MICROSERVICECLOUD-PRIVIDER-DEPT")
@FeignClient(value = "MICROSERVICECLOUD-PRIVIDER-DEPT",fallbackFactory = DeptServiceFollBackFactory.class)
public interface DeptService_Feign {
    @RequestMapping(value="/dept/add",method = RequestMethod.POST)
    public boolean addDept(@RequestBody Dept deptEntity);

    @RequestMapping(value="/dept/findByid/{id}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("id") Long id);

    /**
     * 查询全部
     * @return
     */
    @RequestMapping(value="/dept/findAll",method = RequestMethod.GET)
    public List<Dept> findAll();
}
