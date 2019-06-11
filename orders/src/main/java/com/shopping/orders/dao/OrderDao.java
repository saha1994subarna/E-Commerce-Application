package com.shopping.orders.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.orders.entities.Account;
import com.shopping.orders.entities.Order;





@Repository
public interface OrderDao extends JpaRepository<Order, Long>{

		
		public List<Order> findByAccountAndStatus(Account account, String status);



}
