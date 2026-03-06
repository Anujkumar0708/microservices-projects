package com.amazon.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.order.entity.OrderEntity;
import com.amazon.order.repository.OrderRepository;
import com.amazon.order.request.OrderRequest;
import com.amazon.order.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public int createOrder(OrderRequest orderRequest) {
	
		OrderEntity entity=new OrderEntity();
		entity.setItemName(orderRequest.getItemName());
		entity.setPrice(orderRequest.getPrice());
		entity.setQty(orderRequest.getQty());
		entity.setStatus(orderRequest.getStatus());
		entity.setDescription(orderRequest.getDescription());
		
		entity = orderRepository.save(entity);
		return entity.getOrderId();
	}

	
}
