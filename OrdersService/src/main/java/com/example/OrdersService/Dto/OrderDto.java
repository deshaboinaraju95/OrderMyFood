package com.example.OrdersService.Dto;

import java.util.List;


public class OrderDto {
	
	
	private Long userId;
	
	private Long restaurantId;
	
	private List<MenuItemQuantityDto> menuItemQuantityDto;
	private String note;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public List<MenuItemQuantityDto> getMenuItemQuantityDto() {
		return menuItemQuantityDto;
	}
	public void setMenuItemQuantityDto(List<MenuItemQuantityDto> menuItemQuantityDto) {
		this.menuItemQuantityDto = menuItemQuantityDto;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "OrderDto [userId=" + userId + ", restaurantId=" + restaurantId + ", menuItemQuantityDto="
				+ menuItemQuantityDto + ", note=" + note + "]";
	}
	
	

}
