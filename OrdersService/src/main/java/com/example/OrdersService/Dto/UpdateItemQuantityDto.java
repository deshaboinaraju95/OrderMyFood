package com.example.OrdersService.Dto;

import java.util.List;

public class UpdateItemQuantityDto {
	
	private Long customerId;
	private Long restaurantId;
	private Long orderId;
	private List<UpdateItem> updateItem ;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public List<UpdateItem> getUpdateItem() {
		return updateItem;
	}
	public void setUpdateItem(List<UpdateItem> updateItem) {
		this.updateItem = updateItem;
	}
	
	
	

}
