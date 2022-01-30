package com.example.RestaurantsService.Dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class DistanceResponse {
	
	
	private Long id;
	private String name;
	private Double latitude;
	private Double logitude;
	public DistanceResponse(Long id, String name, Double latitude, Double logitude) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.logitude = logitude;
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	@Override
	public String toString() {
		return "DistanceResponse [id=" + id + ", name=" + name + ", latitude=" + latitude + ", logitude=" + logitude
				+ "]";
	}

}
