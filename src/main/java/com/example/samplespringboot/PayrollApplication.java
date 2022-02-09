package com.example.samplespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class PayrollApplication{
	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);
	}

//	@Bean
//	CommandLineRunner initDatabase(EmployeeRepository employeeRepository) {
//
//		return args -> {
//			System.out.println("Preloading " + employeeRepository.findById(1));
////            log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
//		};
//	}


}



