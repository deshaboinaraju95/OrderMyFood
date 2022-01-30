package com.example.OrdersService.Controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrdersService.Dto.UpdateItemQuantityDto;
import com.example.OrdersService.Service.OrderUpdateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "OrderUpdateController", description = "REST Apis related Orderupdation!!!!")
@RestController
public class OrderUpdateController {

	@Autowired
	private OrderUpdateService orderUpdateService;

	@ApiOperation(value = "Add NewItem to Order", response = String.class)
	@PostMapping("Update/addItem")

	String addItem(@RequestBody UpdateItemQuantityDto updateItemQuantityDto) {
		return orderUpdateService.addItem(updateItemQuantityDto);

	}
	@ApiOperation(value = "remove Item from Order", response = String.class)
	@PostMapping("Update/remooveItem/{customerId}/{orderId}/{removeitemid}")

	String removeItem(@ApiParam(value = "UserId as input", required = true, defaultValue = "1")  @PathVariable(value = "customerId") Long customerId,
			@ApiParam(value = "OrderId as input", required = true, defaultValue = "22")@PathVariable(value = "orderId") Long orderId, @ApiParam(value = "ItemId as input", required = true, defaultValue = "1")@PathVariable(value = "removeitemid") Long removeitemid) {

		return orderUpdateService.removeItem(customerId, orderId, removeitemid);

	}

}
