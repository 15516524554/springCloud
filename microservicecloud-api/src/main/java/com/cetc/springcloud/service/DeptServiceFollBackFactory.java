package com.cetc.springcloud.service;

import com.cetc.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component//不能忘记添加 特别要注意
public class DeptServiceFollBackFactory implements FallbackFactory<DeptService_Feign> {
    @Override
    public DeptService_Feign create(Throwable cause) {
        return new DeptService_Feign() {
            @Override
            public boolean addDept(Dept deptEntity) {
                return false;
            }

            @Override
            public Dept findById(Long id) {
              return new Dept().setDeptNo(id).setDeptName("查询异常").setDbSource("No in Mysql");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }
        };
    }
}
