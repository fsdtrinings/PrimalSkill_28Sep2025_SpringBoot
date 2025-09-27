package com.mkj.app.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mkj.app.entity.Product;
import com.mkj.app.reposoitory.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

	@InjectMocks
	ProductServiceImpl productService;
	/* Use : Class under test 
	 Creates an instance of the class under test and injects the @Mock dependencies
	 into it (either via constructor injection, setter injection, or field injection).
	 So 
	 @InjectMocks tells Mockito: "create productService and put the prepo mock inside it"
	 
	 * */
	
	@Mock
	ProductRepository prepo;
	/* Fake object or when we want to simulate the object
	 * */
	
	/*
		Rule
		1) use @Mock for dependencies.
		2 use @InjectMocks for the class under test.
	 * */
	
	@Test
	void testAddProduct() {
		
		// Sample Data
		Product sampleInput = new Product(0, "Test", 100, 0, "Test-Cat", 0);
		Product expectedOutput = new Product(1, "Test", 100, 0, "Test-Cat", 0);
			
		// Here we are configuring our simulator (test simulator)
		Mockito.when(prepo.save(sampleInput)).thenReturn(expectedOutput);
		
		// hit the actual method / unit 
		Product savedProduct = productService.addProduct(sampleInput);
		
		// test the code
		assertEquals(1, expectedOutput.getProductCode());
	
		
	}

	@Test
	void testFindAll()
	{
		productService.getAllProducts(); // actual hit 
		Mockito.verify(prepo,times(1)).findAll();
		/* So verify is the method which used to check the interaction with the mock object method
		  not just the return value
		 it ensures that mock object method has been called or not 
		 and how many times it get invoked 1,2,3 or 0
		 if fails then assertionError is been thrown
		 * */
	}
	

	@ParameterizedTest
	@ValueSource(ints = {1,2})
	void testGetProductByCode_ValidCode(int code)
	{
		Product p = new Product();
        p.setProductCode(code); 
        
        // configure simulator
        Mockito.when(prepo.findById(code)).thenReturn(Optional.of(p));
        
        // call actual method
        Product result = productService.getProductbyCode(code);
        
        // do testing
        assertNotNull(result);
        assertEquals(code, result.getProductCode());
        Mockito.verify(prepo,times(1)).findById(code);
       
	}
	@ParameterizedTest
	@ValueSource(ints = {0})
	void testGetProductByCode_InvalidCode(int code)
	{
		Product p = new Product();
        p.setProductCode(code); 
        
        // configure simulator
        Mockito.when(prepo.findById(code)).thenReturn(Optional.empty());
        
        // call actual method
        Product result = productService.getProductbyCode(code);
        
        // do testing
        assertNull(result);
        Mockito.verify(prepo,times(1)).findById(code);
       
	}

}
















