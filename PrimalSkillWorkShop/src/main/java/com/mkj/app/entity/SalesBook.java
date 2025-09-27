package com.mkj.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SalesBook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billNo;
	
	private String customerCode;
	private String billdate;
	private int productCode;
	private int discount;
	private int grossprofit;
	private int taxPaid;
	private int netProfit;
	
	
	public SalesBook(String customerCode, String billdate, int productCode, int discount,
			int grossprofit, int taxPaid, int netProfit) {
		super();
		this.customerCode = customerCode;
		this.billdate = billdate;
		this.productCode = productCode;
		this.discount = discount;
		this.grossprofit = grossprofit;
		this.taxPaid = taxPaid;
		this.netProfit = netProfit;
	}
	
	
	
	
	
	
}
