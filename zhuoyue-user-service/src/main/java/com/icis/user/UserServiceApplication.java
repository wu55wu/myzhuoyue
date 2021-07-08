package com.icis.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

//用户服务的一个启动类
@SpringBootApplication
@MapperScan(basePackages = "com.icis.user.mapper")
public class UserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class,args);
	}
}
