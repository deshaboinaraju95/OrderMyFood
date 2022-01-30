package com.example.OrdersService.Dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


public class RestaurantLocationDto {
	
	
	private Long restaurantId;

	
	private String restaurantName;
	
	private Double minimumBudget;
	
	private Double latitude;
	private Double logitude;
    private String address, city, state;
    private Integer zipcode;
    private Long MobileNumber;
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Double getMinimumBudget() {
		return minimumBudget;
	}
	public void setMinimumBudget(Double minimumBudget) {
		this.minimumBudget = minimumBudget;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLogitude() {
		return logitude;
	}
	public void setLogitude(Double logitude) {
		this.logitude = logitude;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	public Long getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public RestaurantLocationDto(Long restaurantId, String restaurantName, Double minimumBudget, 
			Double latitude, Double logitude, String address, String city, String state, Integer zipcode,
			Long mobileNumber) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.minimumBudget = minimumBudget;
		
		this.latitude = latitude;
		this.logitude = logitude;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		MobileNumber = mobileNumber;
	}
	public RestaurantLocationDto() {
		super();
	}
    
	

}
