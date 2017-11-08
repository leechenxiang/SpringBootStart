package com.leecx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// 扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.leecx.mapper")
// 扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages= {"com.leecx", "org.n3r.idworker"})
// 开启定时任务
@EnableScheduling
public class Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
