package com.example.OrdersService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.OrdersService.Dto.MenuItemDto;
import com.example.OrdersService.Dto.MenuItemQuantityDto;
import com.example.OrdersService.Dto.OrderDto;
import com.example.OrdersService.Dto.OrderItemDto;
import com.example.OrdersService.Dto.OrderViewDto;
import com.example.OrdersService.Dto.UserDto;
import com.example.OrdersService.Pojo.Order;
import com.example.OrdersService.Pojo.OrderItem;
import com.example.OrdersService.Pojo.OrderStatus;
import com.example.OrdersService.Repository.OrderItemRepo;
import com.example.OrdersService.Repository.OrderRepo;


@Service
public class OrderService {
	
	@Autowired
    private OrderRepo orderRepo;
	@Autowired
	private OrderItemRepo orderItemRepo;
	@Autowired
	private RestTemplate restTemplate;

	public String  createOrder(OrderDto orderdto) {

		List<MenuItemQuantityDto> menuItemDto = orderdto.getMenuItemQuantityDto();

		Double totalCost = 0.0;
		List<OrderItem> menuItem=new ArrayList<>();
		Order order = new Order(); 

		for (MenuItemQuantityDto m : menuItemDto) {

			MenuItemDto[] menuObject = restTemplate.getForObject(
					"http://localhost:8080/getmenuitem/" + orderdto.getRestaurantId() + "/" + m.getMenuItemId(),
					MenuItemDto[].class);

			totalCost += menuObject[0].getPrice() * m.getQuantity();
			OrderItem menu =new OrderItem();
			menu.setImageUrl(menuObject[0].getImageUrl());menu.setInfo(menuObject[0].getInfo());menu.setName(menuObject[0].getName());menu.setPrice(menuObject[0].getPrice());
            menu.setQunatity(m.getQuantity());
            menu.setRestarurantfkid(orderdto.getRestaurantId());
            menu.setMorder(order);
			menuItem.add(menu);
			
		}

		            
		order.setTotalCost(totalCost);
		order.setNote(orderdto.getNote());
		order.setOrderStatus(OrderStatus.PENDING);
		
		order.setUserfkid(orderdto.getUserId());
		 order.setMitems(menuItem);

		orderRepo.save(order);
		
		
		return "Order Created  sucssfully";
		

	}

	public ResponseEntity<OrderViewDto> viewOrder(UserDto user, Long orderId) {
		
		
		List<OrderItemDto>orderViewList=orderItemRepo.getOrderItemViewByOrderId(orderId);
		Double price =0.0;
		for(OrderItemDto oit:orderViewList)
		{
			price+=oit.getPrice()*oit.getQunatity();
		}
		
		OrderViewDto orderViewDto= new OrderViewDto();
		orderViewDto.setUserName(user.getUserName());
		orderViewDto.setOrderItemDto(orderViewList);
		orderViewDto.setPrice(price);
		orderViewDto.setOrderStaatus(orderRepo.findById(orderId).get().getOrderStatus());
		return new ResponseEntity<>(orderViewDto,HttpStatus.OK);
	
		
		
		
	}

	public String  cancelOrder(Long customerId, Long orderId) {
		OrderStatus cancelled = OrderStatus.CANCELLED;
		orderRepo.cancelOder(customerId,orderId, cancelled);
		
		return "Order Cancelled sucssfully";
	}

	

}
