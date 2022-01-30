package com.example.RestaurantsService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.RestaurantsService.Dto.MenuItemDto;
import com.example.RestaurantsService.Pojo.MenuItem;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

	
	@Query("SELECT DISTINCT new com.example.RestaurantsService.Dto.MenuItemDto(m.name,m.info,m.imageUrl,m.price) from Restaurant r INNER JOIN r.menu as i INNER JOIN i.items as m where r.restaurantId=?1 and m.menuItemid = ?2  ") 

	List<MenuItemDto> FindMenuItems(Long resturentId, Long menuItemId);

}