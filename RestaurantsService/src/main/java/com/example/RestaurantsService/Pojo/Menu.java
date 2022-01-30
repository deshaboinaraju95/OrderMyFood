package com.example.RestaurantsService.Pojo;



import com.fasterxml.jackson.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue
    private Long menuId;

    private String type;

    private String info;

   
    @ManyToMany
    @JoinTable(
    		  name = "menu_menuItem", 
    		  joinColumns = @JoinColumn(name = "menu_fkid"), 
    		  inverseJoinColumns = @JoinColumn(name = "menuitem_fkid"))
    private List<MenuItem> items;

   
    @ManyToMany(mappedBy = "menu",targetEntity=Restaurant.class)
    private List<Restaurant> mrestaurant;

    /*@JsonSetter
    public void setMrestaurant(Restaurant mrestaurant) {
        this.mrestaurant = mrestaurant;
    }

    @JsonGetter
    public Restaurant getMrestaurant() {
        return mrestaurant;
    }
    */
    

  /*  @JsonCreator
    public Menu(@JsonProperty("menuId") Long menuId, @JsonProperty("type") String type, @JsonProperty("info") String info, @JsonProperty("items") List<MenuItem> items) {
        this.menuId = menuId;
        this.type = type;
        this.info = info;
        if (items != null) {
            this.items = items;
            for (MenuItem item : items)
            	items.add(item);
                items.(this);
        }
    }*/

    public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<MenuItem> getItems() {
		return items;
	}

	public void setItems(List<MenuItem> items) {
		this.items = items;
	}

	public void setMrestaurant(List<Restaurant> mrestaurant) {
		this.mrestaurant = mrestaurant;
	}

	public Menu(Long menuId, String type, String info, List<Restaurant> mrestaurant) {
        this.menuId= menuId;
        this.type = type;
        this.info = info;
        this.mrestaurant = mrestaurant;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + menuId +
                ", type='" + type + '\'' +
                ", info='" + info + '\'' +
                ", items=" + items +
                '}';
    }
}