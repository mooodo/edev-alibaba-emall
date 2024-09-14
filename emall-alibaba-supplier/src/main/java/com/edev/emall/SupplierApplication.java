package com.edev.emall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.edev")
@MapperScan("com.edev.support.dao")
public class SupplierApplication {
    public static void main(String[] args) {
        SpringApplication.run(SupplierApplication.class, args);
        System.out.println(".........................................");
        System.out.println(".....The E-Mall Application started......");
        System.out.println(".........................................");
    }
}
