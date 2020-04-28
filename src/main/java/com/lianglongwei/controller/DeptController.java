package com.lianglongwei.controller;

import com.lianglongwei.model.Dept;
import com.lianglongwei.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author LLW
 * @Date 2020/3/30.
 * @Description TODO
 **/
@RestController
public class DeptController {
    @Autowired
    private IService service;
    @GetMapping("/getDepts")
    public List<Dept> getDepts(){
        return service.getDepts();
    }
}
