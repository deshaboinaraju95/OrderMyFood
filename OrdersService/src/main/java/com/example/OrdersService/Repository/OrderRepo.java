package com.example.OrdersService.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.OrdersService.Pojo.Order;
import com.example.OrdersService.Pojo.OrderStatus;



@Repository
public interface OrderRepo  extends JpaRepository<Order, Long>{


	@Modifying
	@Transactional
	@Query("update Order o set o.orderStatus = ?3 where o.userfkid=?1 and o.orderid=?2")

	Integer cancelOder(Long customerId, Long orderId, OrderStatus cancelled);

	@Modifying
	@Transactional
	@Query("update Order o set o.totalCost = ?3 where o.userfkid=?1 and o.orderid=?2")

	void updateTotalPrice(Long customerId, Long orderId, Double totalCost);

	
	
	
	@Modifying
	@Transactional
	@Query("update Order o set o.orderStatus = ?2 where o.orderid=?1")
	void oderCompleted(Long orderId, OrderStatus completed);

	
	
	
	
}
