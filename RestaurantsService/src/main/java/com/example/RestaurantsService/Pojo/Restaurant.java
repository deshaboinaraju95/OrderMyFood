package com.example.RestaurantsService.Pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity

public class Restaurant {
	@Id
	@GeneratedValue
	private Long restaurantId;

	@Column(name="restaurantName")
	private String restaurantName;
	@Column(name="minimumBudget")
	private Double minimumBudget;

	@OneToOne(mappedBy="restaurant")
	private Location location;
	
	
	
	
	//@OneToMany(mappedBy = "mrestaurant", cascade = CascadeType.ALL, orphanRemoval = true)
	 @ManyToMany
	    @JoinTable(
	    		  name = "restaurant_menu", 
	    		  joinColumns = @JoinColumn(name = "rastaurant_fkid"), 
	    		  inverseJoinColumns = @JoinColumn(name = "menu_fkid"))
	   
    private List<Menu> menu;

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
