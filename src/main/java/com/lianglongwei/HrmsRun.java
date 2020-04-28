package com.lianglongwei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author LLW
 * @Date 2020/3/30.
 * @Description 启动类
 **/
@SpringBootApplication
@MapperScan("com.lianglongwei.mapper")
public class HrmsRun {
    public static void main(String[] args) {
        SpringApplication.run(HrmsRun.class,args);
    }
}
