package com.mkj.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.app.entity.Product;
import com.mkj.app.service.ProductService;

@RestController
@RequestMapping("app/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	

	public ProductController() {
		System.out.println("Product Controller");
	}

	
	@GetMapping("/code/{code}")
	public Product getProductByCode(@PathVariable int code)throws Exception
	{
		Product p = productService.getProductbyCode(code);
		if(p!=null)
		{
			return p;
		}
		
		else 
		{
			throw new Exception("Invalid product coode "+code);
		}
	}
	
	@GetMapping("/category/{category}")
	public List<Product> getProductByCategory(@PathVariable String category)
	{
		List<Product> p = productService.getProductsByCartegory(category);
		if(p!=null)
		{
			return p;
		}
		
		else return null;
	}
	
	
	@PostMapping
	public String saveProduct(@RequestBody Product product)
	{
		if(product != null)
		{
			Product savedProduct = productService.addProduct(product);
			return savedProduct.getProductCode()+" "+savedProduct.getProductName()+" Saved";
		}
		return "Error During data saved!!!";
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "test-url";
	}
	
}//end class
