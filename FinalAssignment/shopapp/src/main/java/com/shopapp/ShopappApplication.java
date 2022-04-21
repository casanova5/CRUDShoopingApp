package com.shopapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopapp.dao.Product;
import com.shopapp.service.ProductService;

@SpringBootApplication
public class ShopappApplication implements CommandLineRunner{
	
	@Autowired
	private ProductService productService;
	
	public static void main(String[] args) {
		SpringApplication.run(ShopappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productService.add(new Product("Headphones", 1000.00));
		productService.add(new Product("iPhone", 50332.00));
		System.out.println("--------------------------------------------");
	}

}
