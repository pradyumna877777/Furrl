package com.example.furrl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FurrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(FurrlApplication.class, args);
	}

}
