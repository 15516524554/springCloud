package com.cetc.springcloud.controller;

import com.cetc.springcloud.entity.Dept;
import com.cetc.springcloud.service.DeptService_Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class DeptConsumerController_Feign {
    @Autowired
    private DeptService_Feign service;
    @RequestMapping(value="/dept/add",method = RequestMethod.POST)
    public boolean addDept(@RequestBody Dept deptEntity){
        return service.addDept(deptEntity);
    }

    @RequestMapping(value="/dept/findByid/{id}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("id") Long id){

        return service.findById(id);
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping(value="/dept/findAll",method = RequestMethod.GET)
    public List<Dept> findAll(){
        return service.findAll();
    }
}
