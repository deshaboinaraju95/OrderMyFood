package com.example.RestaurantsService;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.RestaurantsService.Dto.Response;
import com.example.RestaurantsService.Service.RestaurantService;


@SpringBootTest

public class RestaurantsServiceTest {
	
	@Autowired
	private RestaurantService restaurantsService;
	
	@Test
	public void findByCuisine()
	{
		List<Response> findByCuisine = restaurantsService.findByCuisine("Idly");
		//assertEquals("iPhone XR", findByCuisine.get);
		
	}
	

}
