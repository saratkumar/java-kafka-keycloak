package com.example.samplespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);

		System.out.println("Hello world");

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


