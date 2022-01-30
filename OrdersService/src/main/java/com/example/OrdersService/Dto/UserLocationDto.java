package com.example.OrdersService.Dto;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


public class UserLocationDto {
	
	private Long locationId;
	private Double latitude;
	private Double logitude;

    private String address, city, state;
    private Integer zipcode;
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
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
	public UserLocationDto(Long locationId, Double latitude, Double logitude, String address, String city,
			String state, Integer zipcode) {
		super();
		this.locationId = locationId;
		this.latitude = latitude;
		this.logitude = logitude;
		
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	public UserLocationDto() {
		super();
	}
    
    

}
