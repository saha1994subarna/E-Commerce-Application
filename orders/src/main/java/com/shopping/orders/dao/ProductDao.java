package com.shopping.orders.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.orders.entities.Product;

@Repository
public interface ProductDao  extends JpaRepository<Product, Long>{

}