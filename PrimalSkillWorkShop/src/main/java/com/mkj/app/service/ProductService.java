package com.mkj.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkj.app.entity.Product;

@Service
public interface ProductService {

	public Product addProduct(Product product);
	public Product getProductbyCode(int code);
	public List<Product> getAllProducts();
	public List<Product> getProductsByCartegory(String category);
	public int updateProduct(int code,int units);
	
}
