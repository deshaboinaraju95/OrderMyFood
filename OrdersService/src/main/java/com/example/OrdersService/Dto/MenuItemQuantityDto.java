package com.example.OrdersService.Dto;

public class MenuItemQuantityDto {
	
	private Long menuItemId;
	private Long quantity;
	public Long getMenuItemId() {
		return menuItemId;
	}
	public void setMenuItemId(Long menuItemId) {
		this.menuItemId = menuItemId;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "MenuItemQuantityDto [menuItemId=" + menuItemId + ", quantity=" + quantity + "]";
	}
	

}
