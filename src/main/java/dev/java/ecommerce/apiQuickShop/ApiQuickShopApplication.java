package dev.java.ecommerce.apiQuickShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiQuickShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiQuickShopApplication.class, args);
	}

}
