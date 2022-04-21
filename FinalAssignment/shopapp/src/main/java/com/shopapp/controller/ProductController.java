package com.shopapp.controller;

import java.util.*;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopapp.dao.Product;
import com.shopapp.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "products")
	public List<Product> getAll(){
		return productService.getAll();	
	}
	
	@GetMapping(path = "products/{id}")
	public Product getOneProduct(@PathVariable int id){
		return productService.getById(id);	
	}
	
	@PostMapping(path = "products")
	public Product addProduct(@RequestBody Product product) {
		Product newproduct = productService.add(product);
		return newproduct;
	}
	
	@PutMapping(path = "products/{id}")
	public Product UpdateProduct(@RequestBody Product product, @PathVariable int id) {
		Product newproduct = productService.update(id, product);
		return newproduct;
	}
	
	@DeleteMapping(path = "products/{id}")
	public Product deleteProduct(@PathVariable int id) {
		Product productDeleted = productService.delete(id);
		return productDeleted;
	}

}
