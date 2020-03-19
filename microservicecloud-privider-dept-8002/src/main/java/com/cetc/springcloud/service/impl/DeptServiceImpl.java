package com.cetc.springcloud.service.impl;

import com.cetc.springcloud.dao.DeptDao;
import com.cetc.springcloud.entity.Dept;
import com.cetc.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao dao;
    @Override
    public boolean addDept(Dept deptEntity) {

        return dao.addDept(deptEntity);
    }

    @Override
    public Dept findById(Long deptNo) {

        return dao.findById(deptNo);
    }

    @Override
    public List<Dept> findAll() {

        return dao.findAll();
    }
}
