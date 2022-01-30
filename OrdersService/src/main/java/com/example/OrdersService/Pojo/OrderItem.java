package com.example.OrdersService.Pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue
    private Long menuItemid;

    private String name;

    private String info;

    private String imageUrl;

    private Double price;
    private Long qunatity;
   
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="orderfkid")
    private Order morder ;
    
  
    

    
    private Long restarurantfkid;


	public Long getMenuItemid() {
		return menuItemid;
	}


	public void setMenuItemid(Long menuItemid) {
		this.menuItemid = menuItemid;
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


	public Long getQunatity() {
		return qunatity;
	}


	public void setQunatity(Long qunatity) {
		this.qunatity = qunatity;
	}


	public Order getMorder() {
		return morder;
	}


	public void setMorder(Order morder) {
		this.morder = morder;
	}


	public Long getRestarurantfkid() {
		return restarurantfkid;
	}


	public void setRestarurantfkid(Long restarurantfkid) {
		this.restarurantfkid = restarurantfkid;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((menuItemid == null) ? 0 : menuItemid.hashCode());
		result = prime * result + ((morder == null) ? 0 : morder.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((qunatity == null) ? 0 : qunatity.hashCode());
		result = prime * result + ((restarurantfkid == null) ? 0 : restarurantfkid.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (menuItemid == null) {
			if (other.menuItemid != null)
				return false;
		} else if (!menuItemid.equals(other.menuItemid))
			return false;
		if (morder == null) {
			if (other.morder != null)
				return false;
		} else if (!morder.equals(other.morder))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (qunatity == null) {
			if (other.qunatity != null)
				return false;
		} else if (!qunatity.equals(other.qunatity))
			return false;
		if (restarurantfkid == null) {
			if (other.restarurantfkid != null)
				return false;
		} else if (!restarurantfkid.equals(other.restarurantfkid))
			return false;
		return true;
	}


	
    
    
}