package com.mkj.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.app.entity.Product;
import com.mkj.app.reposoitory.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService{

	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	@Transactional
	public Product addProduct(Product product) {
		
		if(product != null)
		{
			Product savedProduct = productRepository.save(product);
			return savedProduct;
		}
		
		return null;
	}

	@Override
	public Product getProductbyCode(int code) {
		Product queriedProduct = productRepository.findById(code).orElse(null);
		return queriedProduct;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductsByCartegory(String category) {
		
		if(category != null && category.isBlank() == false)
		{
			List<Product> allproductsbycategory = productRepository.getProductByCategory(category);
			return allproductsbycategory;
		}
		
		return null;
	}

	@Override
	//@Transactional
	public int updateProduct(int code,int units) {
		System.out.println("inside product impl");
		Product p = getProductbyCode(code);
		System.out.println(" p imp "+p);
		p.setStocksInHand(units);
		System.out.println( "p impl after update units "+p);
		return 1;
	}

	
	
}
