package com.shopapp.service;
import java.util.*;

import com.shopapp.dao.Product;

public interface ProductService {
	public List<Product> getAll();
	public Product getById(int id);
	public Product update(int id, Product product);
	public Product add(Product product);
	public Product delete(int id);
}
