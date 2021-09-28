package daily.coding.demo;

import daily.coding.models.*;
import daily.coding.service.*;
import daily.coding.controller.ExController;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan; //컴포넌트 스캔 안하면 컨트롤러 못 읽음

@MappedTypes(User.class)
@MapperScan("daily.coding.mapper")
@SpringBootApplication
@ComponentScan(basePackageClasses={ExController.class, Bcrypt.class, JWTManager.class}) //컨트롤러 읽기
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
