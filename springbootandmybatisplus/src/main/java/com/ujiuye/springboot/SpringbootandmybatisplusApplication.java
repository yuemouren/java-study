package com.ujiuye.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ujiuye.springboot.mapper")
@SpringBootApplication
public class SpringbootandmybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootandmybatisplusApplication.class, args);
    }
}
