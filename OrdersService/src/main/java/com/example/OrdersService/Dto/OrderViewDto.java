package com.example.OrdersService.Dto;

import java.util.List;

import com.example.OrdersService.Pojo.OrderStatus;

public class OrderViewDto {
	
	private  String UserName;
	private List<OrderItemDto> orderItemDto;
	private Double price ;
	private  OrderStatus   orderStaatus;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	
	public List<OrderItemDto> getOrderItemDto() {
		return orderItemDto;
	}
	public void setOrderItemDto(List<OrderItemDto> orderItemDto) {
		this.orderItemDto = orderItemDto;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public OrderStatus getOrderStaatus() {
		return orderStaatus;
	}
	public void setOrderStaatus(OrderStatus orderStaatus) {
		this.orderStaatus = orderStaatus;
	}
	
	
	
	
	
	
}
