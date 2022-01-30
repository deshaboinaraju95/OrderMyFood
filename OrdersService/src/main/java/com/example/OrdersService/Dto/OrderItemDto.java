package com.example.OrdersService.Dto;

public class OrderItemDto {
	


    private String name;
    private String info;
    private String imageUrl;
    private Double price;
    private Long qunatity;
    

	public OrderItemDto(String name, String info, String imageUrl, Double price, Long qunatity) {
		super();
		this.name = name;
		this.info = info;
		this.imageUrl = imageUrl;
		this.price = price;
		this.qunatity = qunatity;
	}

	public Long getQunatity() {
		return qunatity;
	}

	public void setQunatity(Long qunatity) {
		this.qunatity = qunatity;
	}

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


}
