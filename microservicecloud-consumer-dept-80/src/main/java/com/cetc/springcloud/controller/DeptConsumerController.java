package com.cetc.springcloud.controller;

import com.cetc.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //private static final String URL_PREFIX="http://localhost:8001";
    private static final String URL_PREFIX="microservicecloud-privider-dept8001";
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept){
        return restTemplate.postForObject(URL_PREFIX+"/dept/add",dept,boolean.class);
    }
    @RequestMapping(value = "/consumer/dept/getAll",method = RequestMethod.GET)
    public List<Dept> getAllDept(){
        return restTemplate.getForObject(URL_PREFIX+"/dept/findAll",List.class);
    }
    @RequestMapping(value = "/consumer/dept/getByid/{id}",method = RequestMethod.GET)
    public Dept getDeptById(@PathVariable("id")Long id){
        return restTemplate.getForObject(URL_PREFIX+"/dept/findByid/"+id,Dept.class);
    }
}
