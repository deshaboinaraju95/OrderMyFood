package com.example.OrdersService.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.OrdersService.Dto.DeliveryOrderItemDto;
import com.example.OrdersService.Dto.MenuItemDto;
import com.example.OrdersService.Dto.PaymentInfoDto;
import com.example.OrdersService.Dto.RestaurantLocationDto;
import com.example.OrdersService.Dto.UserDto;
import com.example.OrdersService.Dto.UserLocationDto;
import com.example.OrdersService.Pojo.CreditCardInfo;
import com.example.OrdersService.Pojo.DeliveryInfo;
import com.example.OrdersService.Pojo.Order;
import com.example.OrdersService.Pojo.OrderStatus;
import com.example.OrdersService.Repository.CreditCardRepo;
import com.example.OrdersService.Repository.OrderItemRepo;
import com.example.OrdersService.Repository.OrderRepo;

import freemarker.template.TemplateException;

@Service
public class PaymentService {
	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private CreditCardRepo creditCardRepo;
	@Autowired
	private DeliveryInfo deliveryInfo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private OrderItemRepo orderItemRepo;
	@Autowired
	private EmailService emailservice;

	public String Payment(PaymentInfoDto paymentInfoDto) throws MailException, IOException, TemplateException, MessagingException {

		Order order = orderRepo.findById(paymentInfoDto.getOrderId()).get();

		if (order.getTotalCost() == paymentInfoDto.getAmount()) {

			CreditCardInfo creditCardInfo = creditCardRepo.findById(paymentInfoDto.getCraditCardId()).get();

			if (creditCardInfo.getExpiredMonth() == paymentInfoDto.getExpiredMonth()
					&& creditCardInfo.getExpiredYear() == paymentInfoDto.getExpiredYear()
					&& creditCardInfo.getSecurityCode() == paymentInfoDto.getSecurityCode()) {

				OrderStatus completed = OrderStatus.COMPLETED;

				orderRepo.oderCompleted(paymentInfoDto.getOrderId(), completed);

				UserDto user = restTemplate.getForObject("http://localhost:8082/getuser/" + order.getUserfkid(),
						UserDto.class);
			

				UserLocationDto userLationdtonDto = restTemplate.getForObject(
						"http://localhost:8082/getuserlocation/" + order.getUserfkid(), UserLocationDto.class);

				List<DeliveryOrderItemDto> deliveryOrderItemDtoList = orderItemRepo.deliveryOrderItem(paymentInfoDto.getOrderId());
				
				RestaurantLocationDto restaurantLocationDto = restTemplate.getForObject(
						"http://localhost:8080/getrestaurantandlocation/" + deliveryOrderItemDtoList.get(0).getRestarurantfkid(), RestaurantLocationDto.class);

				double distFrom = PaymentService.distFrom(restaurantLocationDto.getLatitude(), restaurantLocationDto.getLogitude(), userLationdtonDto.getLatitude(), userLationdtonDto.getLogitude());

				deliveryInfo.setAverageDeliveryTime(distFrom/10+"Hr");
				deliveryInfo.setCharge(distFrom/1000);
				deliveryInfo.setDeliveryDistance(distFrom);
				 //Long round = Math.round   ( order.getTotalCost() +deliveryInfo.getCharge());
				Double charge = deliveryInfo.getCharge();
				Double chages =(double)charge.intValue();
				     
				     Double total =order.getTotalCost()+chages;
			
				     System.out.println("charges"+chages);
				emailservice.sendEmail(user,userLationdtonDto,deliveryOrderItemDtoList,restaurantLocationDto,total,(long)deliveryInfo.getCharge());
				
				return "Payment succssfull and order detailes sended to delivery team";

			} else {
				return "pls enter valid carddetails";
			}

		} else {
			return "pls enter valid amount";
		}

		
	}
	public static double distFrom(double d, double e, double f, double g) {
		double earthRadius = 6371000; // meters
		double dLat = Math.toRadians(f - d);
		double dLng = Math.toRadians(g - e);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(Math.toRadians(d)) * Math.cos(Math.toRadians(f)) * Math.sin(dLng / 2) * Math.sin(dLng / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double dist = (earthRadius * c);

		return dist; // Math.round(dist*100) / 100.0;
	}

}
