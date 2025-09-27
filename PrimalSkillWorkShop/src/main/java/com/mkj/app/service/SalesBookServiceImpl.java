package com.mkj.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkj.app.entity.Product;
import com.mkj.app.entity.SalesBook;
import com.mkj.app.reposoitory.SalesBookRepository;

@Service
public class SalesBookServiceImpl implements SalesBookService{

	@Autowired
	SalesBookRepository salesbookRepo;
	
	@Autowired
	ProductService pservice;
	
	@Override
	@Transactional
	public SalesBook addSales(SalesBook sales) {
		
		Product p = pservice.getProductbyCode(sales.getProductCode());
		int stockInHand = p.getStocksInHand();
		if(stockInHand>1)
		{
			System.out.println("2 inside if impl"+p);
			int gp = (p.getSellingPrice()-p.getCostPrice())-sales.getDiscount();
			int tax = (int)(gp*0.07);
			int np = gp-tax;
			
			sales.setGrossprofit(gp);
			sales.setTaxPaid(tax);
			sales.setNetProfit(np);
			
			int x = p.getStocksInHand();
			p.setStocksInHand(--x);
			
			SalesBook sb =  salesbookRepo.save(sales);
			
			System.out.println("SB data inserted "+sb);
			
			
			return sb;
		
			
		}
		else return null;
		
		
		
		
	}

	@Override
	public List<SalesBook> viewAllrecord() {
		return salesbookRepo.findAll();
	}

	
}
