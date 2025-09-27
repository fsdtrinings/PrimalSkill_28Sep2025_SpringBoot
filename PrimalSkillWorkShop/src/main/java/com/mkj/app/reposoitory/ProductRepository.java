package com.mkj.app.reposoitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkj.app.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	public List<Product> getProductByCategory(String category);
}
