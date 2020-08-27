package com.rcm.weigouproductservice;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.rcm.mapper")
public class WeigouProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeigouProductServiceApplication.class, args);
    }

}
