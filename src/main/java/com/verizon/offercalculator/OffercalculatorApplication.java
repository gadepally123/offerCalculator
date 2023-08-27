package com.verizon.offercalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.verizon.offercalculator")
public class OffercalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OffercalculatorApplication.class, args);
	}

}
