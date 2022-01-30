package com.example.OrdersService.Repository;

import java.util.List;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.OrdersService.Dto.DeliveryOrderItemDto;
import com.example.OrdersService.Dto.OrderItemDto;
import com.example.OrdersService.Pojo.OrderItem;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {

	
	
	@Query("SELECT new com.example.OrdersService.Dto.OrderItemDto (i.name,i.info,i.imageUrl,i.price,i.qunatity) from OrderItem i INNER JOIN i.morder m where m.orderid=?1")
	List<OrderItemDto> getOrderItemViewByOrderId(Long orderId);

	

	@Query("SELECT new com.example.OrdersService.Dto.DeliveryOrderItemDto (i.name,i.info,i.imageUrl,i.price,i.qunatity,i.restarurantfkid) from OrderItem i INNER JOIN i.morder m where m.orderid=?1")
	List<DeliveryOrderItemDto> deliveryOrderItem(Long orderId);

	

	   
}