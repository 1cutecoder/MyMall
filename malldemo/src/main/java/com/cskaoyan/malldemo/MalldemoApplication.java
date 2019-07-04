package com.cskaoyan.malldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cskaoyan.malldemo.mapper")
public class MalldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MalldemoApplication.class, args);
    }

}
