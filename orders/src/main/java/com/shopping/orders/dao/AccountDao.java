package com.shopping.orders.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.orders.entities.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Long>{

	public Optional<Account> findByCustomerId(Long customerId);
		
}
