package com.amazon.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.order.request.OrderRequest;
import com.amazon.order.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	IOrderService iOrderService;
	
	@PostMapping("/place-order")
	public ResponseEntity placeOrder(@RequestBody OrderRequest orderRequest)
	{

		iOrderService.createOrder(orderRequest);

		return ResponseEntity.ok(HttpStatus.OK);
	}
}
