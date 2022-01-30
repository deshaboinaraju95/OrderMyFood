package com.example.OrdersService.Dto;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



public class DeliveryOrderItemDto {

	private String name;

	private String info;

	private String imageUrl;

	private Double price;
	private Long qunatity;

	private Long restarurantfkid;

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
		return price ;
	}

	public void setPrice(Double price) {
		this.price = price ;
	}

	public Long getQunatity() {
		return qunatity;
	}

	public void setQunatity(Long qunatity) {
		this.qunatity = qunatity;
	}

	public Long getRestarurantfkid() {
		return restarurantfkid;
	}

	public void setRestarurantfkid(Long restarurantfkid) {
		this.restarurantfkid = restarurantfkid;
	}

	public DeliveryOrderItemDto(String name, String info, String imageUrl, Double price, Long qunatity,
			Long restarurantfkid) {
		super();
		this.name = name;
		this.info = info;
		this.imageUrl = imageUrl;
		this.price = price;
		this.qunatity = qunatity;
		this.restarurantfkid = restarurantfkid;
	}

	@Override
	public String toString() {
		return "DeliveryOrderItemDto [name=" + name + ", info=" + info + ", imageUrl=" + imageUrl + ", price=" + price
				+ ", qunatity=" + qunatity + ", restarurantfkid=" + restarurantfkid + "]";
	}


}
