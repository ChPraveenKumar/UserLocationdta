package com.userlocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class UserLocationdtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserLocationdtoApplication.class, args);
	}
}
