package com.example.RestaurantsService;

import javax.transaction.Transactional;




import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.swagger2.annotations.EnableSwagger2;




@SpringBootApplication
@EnableJpaAuditing
@Transactional
@EnableSwagger2
@EnableEurekaClient
public class RestaurantsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantsServiceApplication.class, args);
	}

}
