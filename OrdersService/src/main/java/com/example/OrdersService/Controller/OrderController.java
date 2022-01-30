package com.example.OrdersService.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.OrdersService.Dto.MenuItemDto;
import com.example.OrdersService.Dto.OrderDto;
import com.example.OrdersService.Dto.OrderViewDto;
import com.example.OrdersService.Dto.UserDto;
import com.example.OrdersService.Pojo.Order;
import com.example.OrdersService.Service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "OrderController", description = "REST Apis related Order!!!!")

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private RestTemplate restTemplate;

	@ApiOperation(value = "Create New Order", response = String.class)

	@PostMapping("createorder")

	private String createOrder(@RequestBody OrderDto orderdto)

	{
		System.out.println(orderdto);
		return orderService.createOrder(orderdto);

	}

	@HystrixCommand(fallbackMethod = "callUserServiceAndGetData_Fallback")
	@ApiOperation(value = "View Created Order", response = OrderViewDto.class)
	@GetMapping("vieworder/{customerId}/{orderId}")
	public ResponseEntity<OrderViewDto> viewOrder(
			@ApiParam(value = "UserId as input", required = true, defaultValue = "1") @PathVariable(value = "customerId") Long customerId,
			@ApiParam(value = "OrderId as input", required = true, defaultValue = "22") @PathVariable(value = "orderId") Long orderId)

	{

		UserDto user = restTemplate.getForObject("http://localhost:8082/getuser/" + customerId, UserDto.class);
		return orderService.viewOrder(user, orderId);

	}
	 @SuppressWarnings("unused")
	    private String callUserServiceAndGetData_Fallback( Long customerId,Long orderId) {
	 
	        System.out.println("User Service is down!!! fallback route enabled...");
	 
	        return "CIRCUIT BREAKER ENABLED!!! No Response From User Service at this moment. " +
	                    " Service will be back shortly - " + new Date();
	    }

	@ApiOperation(value = "Cancel Created Order", response = String.class)
	@PostMapping("cancelOrder/{customerId}/{orderId}")
	public String cancelOrder(
			@ApiParam(value = "UserId as input", required = true, defaultValue = "1") @PathVariable(value = "customerId") Long customerId,
			@ApiParam(value = "OrderId as input", required = true, defaultValue = "22") @PathVariable(value = "orderId") Long orderId)

	{

		return orderService.cancelOrder(customerId, orderId);

	}

}
