package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.Callable;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.example.demo.dao")
public class DemoApplication {
	// 启动类
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
