package com.shopping.orders.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.orders.exceptions.OrderPlacingBusinessException;
import com.shopping.orders.model.OrderVO;
import com.shopping.orders.services.OrderService;

@RestController
@RequestMapping("/order/v1")
public class OrderController {


	//private static final Logger LOGGER = Logger.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

	@RequestMapping(value="/bill/{accountId}",  method = RequestMethod.GET)
	public OrderVO getBill(@PathVariable("accountId") long accountId) {

		OrderVO orderVO = new OrderVO();

		try {
			orderVO = orderService.checkOut(accountId);

			orderVO.setMessage("SUCCESS");
			
			//TODO: once is order is fetched succefully need to move the order from pending status to completed so that it cannot be fetched again for that account
		
		}catch (OrderPlacingBusinessException orderPlacingBusinessException) {

			//LOGGER.error("Failed to generate bill, message="+orderPlacingBusinessException.getMessage());

			orderVO.setMessage("FAILED");
		}
		catch (Exception e) {

			//LOGGER.error("Failed to generate bill, message="+e.getMessage());
			orderVO.setMessage("FAILED");

		}

		return orderVO;
	}

}


