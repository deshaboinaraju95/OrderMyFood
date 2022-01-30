package com.example.OrdersService.Dto;

public class UpdateItem {
	
	private Long itemId;
	private Long newquantiy;
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	
	
	public Long getItemId() {
		return itemId;
	}



	public Long getNewquantiy() {
		return newquantiy;
	}
	public void setNewquantiy(Long newquantiy) {
		this.newquantiy = newquantiy;
	}

}
