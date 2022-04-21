package com.shopapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopapp.dao.Product;
import com.shopapp.dao.ProductDao;
import com.shopapp.exceptions.ProductNotFoundException;

@Service
@Transactional
public class ProductServiceImp implements ProductService{
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getAll() {
		return productDao.findAll();
	}

	@Override
	public Product getById(int id) {
		Product product = productDao.findById(id).
				orElseThrow(()-> new ProductNotFoundException("product with id "+ id+ " is not found"));
		return product;
	}

	@Override
	public Product update(int id, Product product) {
		Product productToUpdate = getById(id);
		productToUpdate.setPrice(product.getPrice());
		productDao.save(productToUpdate);
		return productToUpdate;
	}

	@Override
	public Product add(Product product) {
		productDao.save(product);
		return product;
	}

	@Override
	public Product delete(int id) {
		Product productToDelete = getById(id);
		productDao.delete(productToDelete);
		return productToDelete;
	}

}
