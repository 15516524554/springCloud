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
    //@HystrixCommand(fallbackMethod = "exceptionHystrix")
    public Dept findById(@PathVariable("id") Long id){
        Dept dept=service.findById(id);
        if(dept==null){
            throw  new RuntimeException("该id在数据库不存在");
        }
        return dept;
    }
   /* public Dept exceptionHystrix(@PathVariable("id") Long id){
            return new Dept().setDeptNo(id).setDeptName("查询异常").setDbSource("No in Mysql");
    }*/


    @RequestMapping(value="/dept/findAll",method = RequestMethod.GET)
    public List<Dept> findAll(){
        return service.findAll();
    }
}
