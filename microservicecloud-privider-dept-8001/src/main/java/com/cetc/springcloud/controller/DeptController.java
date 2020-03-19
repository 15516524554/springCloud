package com.cetc.springcloud.controller;

import com.cetc.springcloud.entity.Dept;
import com.cetc.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @RequestMapping(value="/dept/add",method = RequestMethod.POST)
    public boolean addDept(@RequestBody Dept deptEntity){
        return service.addDept(deptEntity);
    }

    @RequestMapping(value="/dept/findByid/{id}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("id") Long id){
        return service.findById(id);
    }


    @RequestMapping(value="/dept/findAll",method = RequestMethod.GET)
    public List<Dept> findAll(){
        return service.findAll();
    }
}
