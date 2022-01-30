package com.example.RestaurantsService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.RestaurantsService.Dto.DistanceResponse;
import com.example.RestaurantsService.Dto.Response;
import com.example.RestaurantsService.Dto.RestaurantLocationDto;
import com.example.RestaurantsService.Pojo.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {

	
	@Query("SELECT DISTINCT new com.example.RestaurantsService.Dto.Response(r.restaurantId,r.restaurantName) from Restaurant r INNER JOIN r.menu as i INNER JOIN i.items as m where m.name = ?1 ") 

	List<Response> searchByCuisine(String val);                                                                                                                  
                                                                                                                                                                 
     

	@Query("SELECT DISTINCT new com.example.RestaurantsService.Dto.Response(r.restaurantId,r.restaurantName) from Restaurant r INNER JOIN r.menu as i where  i.type like ?1%")  //UPPER(i.type) LIKE UPPER('?1%')
	
	List<Response> searchByMenu(String val);
	
	@Query("SELECT DISTINCT new com.example.RestaurantsService.Dto.Response(r.restaurantId,r.restaurantName) from Restaurant r where r.restaurantName LIKE ?1%") 
	List<Response> searchByName(String val);
	               

	@Query("SELECT DISTINCT new com.example.RestaurantsService.Dto.Response(r.restaurantId,r.restaurantName) from Restaurant r INNER JOIN r.location as l where l.address LIKE  %?1%  or l.city LIKE %?1% or l.state LIKE %?1%")

	List<Response> searchByLocation(String val);



	


	@Query("SELECT DISTINCT new com.example.RestaurantsService.Dto.DistanceResponse(r.restaurantId,r.restaurantName,l.latitude,l.logitude) from Restaurant r INNER JOIN r.location as l ") 
	
	List<DistanceResponse> searchByDistance();


	@Query("SELECT DISTINCT new com.example.RestaurantsService.Dto.Response(r.restaurantId,r.restaurantName) from Restaurant r where r.minimumBudget< ?1 or r.minimumBudget=  ?1 ORDER BY r.minimumBudget") 
	
	List<Response> searchByBudget(Double d);


	


	@Query("SELECT DISTINCT new com.example.RestaurantsService.Dto.RestaurantLocationDto(r.restaurantId,r.restaurantName,r.minimumBudget,l.latitude,l.logitude,l.address,l.city,l.state,l.zipcode,l.MobileNumber) from Restaurant r INNER JOIN r.location as l where r.restaurantId=?1") 
	
	List<RestaurantLocationDto> restaurantAndLocation(Long resturentId);
	
}
