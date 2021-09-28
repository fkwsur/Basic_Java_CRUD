package com.example.demo;

import com.example.models.*;
import com.example.service.*;
import com.example.controller.ExController;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MappedTypes(User.class)
@MapperScan("com.example.mapper")
@SpringBootApplication
@ComponentScan(basePackageClasses={ExController.class, Bcrypt.class, JWTManager.class})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
