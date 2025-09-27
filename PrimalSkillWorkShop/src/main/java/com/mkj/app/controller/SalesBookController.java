package com.mkj.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.app.entity.Product;
import com.mkj.app.entity.SalesBook;
import com.mkj.app.service.ProductService;
import com.mkj.app.service.SalesBookService;

@RestController
@RequestMapping("/app/sales")
public class SalesBookController {

	@Autowired
	SalesBookService sbService;
	
	@Autowired
	ProductService productService;
	
	
	public SalesBookController() {
		System.out.println("sales book controller called");
	}

	@PutMapping("/commit")
	public String SalesBookAdd(@RequestParam String ccode,@RequestParam int pcode,@RequestParam int dis)
	{
		
		
		
		String date = LocalDate.now().toString();
		
		SalesBook sb = new SalesBook();
		sb.setCustomerCode(ccode);
		sb.setProductCode(pcode);
		sb.setDiscount(dis);
		sb.setBilldate(date);
		
		SalesBook updatedSB = sbService.addSales(sb);
		System.out.println("last :- "+updatedSB);
		return updatedSB.getBillNo()+"";
	}
	
	@GetMapping
	public List<SalesBook> getAllData()
	{
		return sbService.viewAllrecord();
	}
	
}
