package com.example.OrdersService.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.OrdersService.Dto.MenuItemDto;
import com.example.OrdersService.Dto.UpdateItem;
import com.example.OrdersService.Dto.UpdateItemQuantityDto;
import com.example.OrdersService.Pojo.OrderItem;
import com.example.OrdersService.Repository.OrderItemRepo;
import com.example.OrdersService.Repository.OrderRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class OrderUpdateService {
	@Autowired
	private OrderItemRepo orderItemRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private OrderRepo orderrepo;

	@HystrixCommand(fallbackMethod = "callMenuItemServiceAndGetData_Fallback")

	public String addItem(UpdateItemQuantityDto updateItemQuantityDto) {

		OrderItem orderItem = new OrderItem();

		Double totalCost = orderrepo.findById(updateItemQuantityDto.getOrderId()).get().getTotalCost();
		List<UpdateItem> updateItemList = updateItemQuantityDto.getUpdateItem();
		for (UpdateItem ui : updateItemList) {

			MenuItemDto[] menuObject = restTemplate.getForObject("http://localhost:8080/getmenuitem/"
					+ updateItemQuantityDto.getRestaurantId() + "/" + ui.getItemId(), MenuItemDto[].class);

			totalCost += menuObject[0].getPrice() * ui.getNewquantiy();
			OrderItem menu = new OrderItem();

			menu.setImageUrl(menuObject[0].getImageUrl());
			menu.setInfo(menuObject[0].getInfo());
			menu.setName(menuObject[0].getName());
			menu.setPrice(menuObject[0].getPrice());
			menu.setQunatity(ui.getNewquantiy());
			menu.setRestarurantfkid(updateItemQuantityDto.getRestaurantId());
			menu.setMorder(orderrepo.findById(updateItemQuantityDto.getOrderId()).get());

			orderItemRepo.save(menu);

		}

		orderrepo.updateTotalPrice(updateItemQuantityDto.getCustomerId(), updateItemQuantityDto.getOrderId(),
				totalCost);

		return "item  added";

	}
	@SuppressWarnings("unused")
    private String callMenuItemServiceAndGetData_Fallback( UpdateItemQuantityDto updateItemQuantityDto) {
 
        System.out.println("MenuItem Service is down!!! fallback route enabled...");
 
        return "CIRCUIT BREAKER ENABLED!!! No Response From MenuItem Service at this moment. " +
                    " Service will be back shortly - " + new Date();
    }

	public String removeItem(Long customerId, Long orderId, Long removeitemid) {

		orderItemRepo.deleteById(removeitemid);

		return "item removed";
	}

}
