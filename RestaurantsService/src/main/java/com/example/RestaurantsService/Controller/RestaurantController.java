package com.example.RestaurantsService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestaurantsService.Dto.MenuItemDto;
import com.example.RestaurantsService.Dto.Response;
import com.example.RestaurantsService.Dto.RestaurantLocationDto;
import com.example.RestaurantsService.Pojo.MenuItem;
import com.example.RestaurantsService.Pojo.Restaurant;

import com.example.RestaurantsService.Service.RestaurantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.example.RestaurantsService.Repository.RestaurantRepo;

@Api(value = "RestaurantController", description = "REST Apis related Search Restaurant!!!!")
@RestController
@RequestMapping("/api")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

	@ApiOperation(value = "Search Restaurant By Name  ", response = Response.class)

	@GetMapping("search/Restaurant/{restaurantName}")
	public ResponseEntity<List<Response>> findByRestaurantName(
			@ApiParam(value = "RestaurantName as input", required = true, defaultValue = "Bidri") @PathVariable(value = "restaurantName") String restaurantName) {

		List<Response> restaurant = restaurantService.findByResturentName(restaurantName);
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}

	@ApiOperation(value = "Search Restaurant By LocationName  ", response = Response.class)

	@GetMapping("SearchRestaurant/location/{locationName}")
	public ResponseEntity<List<Response>> findByLocation(
			@ApiParam(value = "LocationNmae as input", required = true, defaultValue = "Hyderabad") @PathVariable(value = "locationName") String locationName) {

		List<Response> restaurant = restaurantService.findByLocation(locationName);
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}

	@ApiOperation(value = "Search Restaurant By CuisineName  ", response = Response.class)

	@GetMapping("SearchRestaurant/cuisine/{cuisineName}")
	public ResponseEntity<List<Response>> findByCuisine(
			@ApiParam(value = "CuisioneName as input", required = true, defaultValue = "Idly") @PathVariable(value = "cuisineName") String cuisineName) {

		List<Response> restaurant = restaurantService.findByCuisine(cuisineName);
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}

	@ApiOperation(value = "Search Restaurant By FoodMenuName  ", response = Response.class)

	@GetMapping("SearchRestaurant/MenuName/{foodMenuName}")
	public ResponseEntity<List<Response>> findByfoodMenu(
			@ApiParam(value = "FoodmenuName as input", required = true, defaultValue = "veg") @PathVariable(value = "foodMenuName") String foodMenuName) {

		List<Response> restaurant = restaurantService.findByFoodMenu(foodMenuName);
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}

	@ApiOperation(value = "Search Restaurant By Budget  ", response = Response.class)

	@GetMapping("SearchRestaurant/budget/{budget}")
	public ResponseEntity<List<Response>> findByMenuItem(
			@ApiParam(value = "Budget amount as input", required = true, defaultValue = "500") @PathVariable(value = "budget") String budget) {

		List<Response> restaurant = restaurantService.findByBudget(budget);
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}

	@ApiOperation(value = "Search Restaurant By Distance", response = Response.class)

	@GetMapping("SearchRestaurant/distance/{latitudeandlongitude}")
	public ResponseEntity<List<Response>> findByDistance(
			@ApiParam(value = "Logitude and Latitude as input", required = true, defaultValue = "17.50042741645827,78.77778768629116") @PathVariable(value = "latitudeandlongitude") String latitudeandlongitude) {

		List<Response> restaurant = restaurantService.findyDistance(latitudeandlongitude);
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}

	@ApiOperation(value = " Get menu Item List in the System  ", response = MenuItemDto.class, responseContainer = "List")

	@GetMapping("getmenuitem/{resturentId}/{menuItemId}")

	public ResponseEntity<List<MenuItemDto>> FindRestarentItem(
			@ApiParam(value = "RestarentId as input", required = true, defaultValue = "1") @PathVariable Long resturentId,
			@ApiParam(value = "MenuItemId as input", required = true, defaultValue = "1") @PathVariable Long menuItemId) {

		List<MenuItemDto> menuItem = restaurantService.FindMenuItem(resturentId, menuItemId);
		return new ResponseEntity<>(menuItem, HttpStatus.OK);
	}

	@ApiOperation(value = " Get Restaurant And Location in the System  ", response = RestaurantLocationDto.class)
	@GetMapping("getrestaurantandlocation/{resturentId}")

	public RestaurantLocationDto restaurantAndLocation(
			@ApiParam(value = "RestarentId as input", required = true, defaultValue = "1") @PathVariable Long resturentId) {

		return restaurantService.restaurantAndLocation(resturentId);

	}

}
