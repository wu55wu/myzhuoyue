package com.icis.commonmapper;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

//springboot的一个启动类
@SpringBootApplication
//开启mapper包扫描
@MapperScan(basePackages = "com.icis.commonmapper.mapper")
public class MapperApplication {
	public static void main(String[] args) {
		SpringApplication.run(MapperApplication.class,args);
	}
}
