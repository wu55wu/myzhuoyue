package com.icis.commonmapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springboot的一个启动类
@SpringBootApplication
@MapperScan(basePackages = "com.icis.commonmapper.mapper.UserInfoMapper")
public class MapperApplication {
	public static void main(String[] args) {
		SpringApplication.run(MapperApplication.class,args);
	}
}
