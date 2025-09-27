package com.mkj.app.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.mkj.app.entity.Product;
import com.mkj.app.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc; //mock http client

	@MockBean // used to mock the service layer
	private ProductService productService;
	
	@Autowired
	private ObjectMapper objectMapper; // To convert objects <-> JSON
	
	@Test
	@Disabled
	void testAddProduct()throws Exception
	{
		Product inputProduct = new Product();
		inputProduct.setProductName("Laptop");
		inputProduct.setCategory("Electronics");
		
		Product outputProduct = new Product();
		outputProduct.setProductName("Laptop");
		outputProduct.setCategory("Electronics");
		outputProduct.setProductCode(1);
		
		Mockito.when(productService.addProduct(inputProduct)).thenReturn(outputProduct);
		
		mockMvc.perform(post("/app/product")
				.contentType(MediaType.APPLICATION_JSON)
				.contentType(objectMapper.writeValueAsString(outputProduct)))
				.andExpect(status().isOk());
		
		Mockito.verify(productService,times(1)).addProduct(inputProduct);
				
				
				
		
	}
	
	
	@Test
	void testgetProductByCode() throws Exception{
		// sample data
		Product product = new Product();
        product.setProductCode(1);
        product.setProductName("Laptop");

        // setting the simulator
        Mockito.when(productService.getProductbyCode(1)).thenReturn(product);

        // hit the api using mock client
        mockMvc.perform(get("/app/product/code/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productCode").value(1))
                .andExpect(jsonPath("$.productName").value("Laptop"));

        Mockito.verify(productService,times(1)).getProductbyCode(1);
	
	}
	
	

}
