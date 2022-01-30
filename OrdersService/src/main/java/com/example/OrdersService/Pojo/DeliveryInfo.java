package com.example.OrdersService.Pojo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class DeliveryInfo {

   
  
    private double charge;
    private double DeliveryDistance; 
    private String averageDeliveryTime;
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	
	public double getDeliveryDistance() {
		return DeliveryDistance;
	}
	public void setDeliveryDistance(double deliveryDistance) {
		DeliveryDistance = deliveryDistance;
	}
	public String getAverageDeliveryTime() {
		return averageDeliveryTime;
	}
	public void setAverageDeliveryTime(String averageDeliveryTime) {
		this.averageDeliveryTime = averageDeliveryTime;
	}


}
