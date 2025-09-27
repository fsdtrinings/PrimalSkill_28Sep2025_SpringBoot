package com.mkj.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkj.app.entity.Product;
import com.mkj.app.entity.SalesBook;

@Service
public interface SalesBookService {

	public SalesBook addSales(SalesBook sales);
	public List<SalesBook> viewAllrecord();
	
	
	
}
