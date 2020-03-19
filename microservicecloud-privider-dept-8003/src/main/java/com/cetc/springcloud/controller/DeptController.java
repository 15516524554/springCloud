package com.cetc.springcloud.controller;

import com.cetc.springcloud.entity.Dept;
import com.cetc.springcloud.service.DeptService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService service;
    @Autowired
    private DiscoveryClient client;
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
    @RequestMapping(value="/dept/findDistoryClient",method = RequestMethod.GET)
    public Object getDistory(){
        List<InstanceInfo> instancesById = client.getInstancesById("microservicecloud-privider-dept8001");
        for(InstanceInfo i:instancesById){
        System.out.println(i.getAppName()+"-----"+i.getHostName()+"-----"+i.getPort());
        }
        return client;
    }
}
