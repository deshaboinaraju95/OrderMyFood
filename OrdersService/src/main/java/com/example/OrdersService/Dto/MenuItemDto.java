package com.example.OrdersService.Dto;

public class MenuItemDto {

	private String name;

	private String info;

	private String imageUrl;

	private Double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public MenuItemDto(String name, String info, String imageUrl, Double price) {
		super();

		this.name = name;
		this.info = info;
		this.imageUrl = imageUrl;
		this.price = price;
	}

	public MenuItemDto() {
	}

}
