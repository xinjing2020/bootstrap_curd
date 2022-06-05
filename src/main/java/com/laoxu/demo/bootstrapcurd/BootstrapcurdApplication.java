package com.laoxu.demo.bootstrapcurd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.laoxu.demo.bootstrapcurd.mapper")
public class BootstrapcurdApplication {

    public static void main(String[] args) {
        SpringApplication.run (BootstrapcurdApplication.class, args);
    }

}
