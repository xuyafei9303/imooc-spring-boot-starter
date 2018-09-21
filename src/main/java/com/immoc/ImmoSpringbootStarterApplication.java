package com.immoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// 扫描mybatis mapper的包路径
@MapperScan(basePackages = "com.immoc.mapper")
// 扫描所有需要的包，包含一些自用的工具类包所在的路径
@ComponentScan(basePackages = {"com.immoc", "org.n3r.idworker"})
public class ImmoSpringbootStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImmoSpringbootStarterApplication.class, args);
    }
}
