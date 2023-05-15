package com.example.SiteRestaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories(basePackages = "com.example.SiteRestaurant.repository")
public class SiteRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiteRestaurantApplication.class, args);
	}

}
