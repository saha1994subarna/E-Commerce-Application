package com.shopping.orders.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.orders.dao.AccountDao;
import com.shopping.orders.dao.OrderDao;
import com.shopping.orders.entities.Account;
import com.shopping.orders.entities.Order;
import com.shopping.orders.entities.Product;
import com.shopping.orders.exceptions.OrderPlacingBusinessException;
import com.shopping.orders.model.Item;
import com.shopping.orders.model.OrderVO;

@Service
public class OrderService {
	
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private OrderDao orderDao;
	
	
	public OrderVO checkOut(Long accountId) throws OrderPlacingBusinessException{

		//Get User  Account Detail
		Optional<Account> account = accountDao.findByAccountId(accountId);
		
		if(account.isPresent()==false) 
			throw new OrderPlacingBusinessException("Account does not exist.","EC001");//TODO: Create a new POJO with static final constansts variables for ERROR CONSTANTS or ENUMs
		
		//LOGGER.info("Starting billing for account=["+account.get().getName()+"]");

		List<Order> orders = getOrderDetails(accountId);
		OrderVO orderVO =  new OrderVO();
		
		
		//Setting user account details
		orderVO.setAccountId(accountId);
		orderVO.setAccountHolderName(account.get().getName());
		orderVO.setDate(new Date());
		
		List<Item> items = new ArrayList<Item>();

		for(Order order : orders) {
			
			Product product = order.getProduct();
			
			//Setting up item related info
			Item item = new Item();
			item.setItemId(product.getProductId());
			item.setItemName(product.getProductName());
			item.setUnitPrice(product.getUnitPrice());
			item.setNumberOfUnits(order.getQuantity());

			BigDecimal totalPrice = product.getUnitPrice().multiply(new BigDecimal(order.getQuantity()));

			item.setTotalAmount(totalPrice);

			items.add(item);
		}

		
		//Setting up all the values at bill-level
		orderVO.setItems(items);
		

		return orderVO;
	}
	

	public List<Order> getOrderDetails(Long accountId) {

		//LOGGER.info("Checking for OrderDetails for account=["+accountId+"]");
		
		Account account = new Account();
		account.setAccountId(accountId);
		
		List<Order> orderList = orderDao.findByAccountAndStatus(account, "PENDING");
		
		return orderList;
	}
}
