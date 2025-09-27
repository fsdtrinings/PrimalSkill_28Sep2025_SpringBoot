package com.mkj.app.reposoitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkj.app.entity.Product;
import com.mkj.app.entity.SalesBook;

@Repository
public interface SalesBookRepository extends JpaRepository<SalesBook, Integer>
{
}
	
