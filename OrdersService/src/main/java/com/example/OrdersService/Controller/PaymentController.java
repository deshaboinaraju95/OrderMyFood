package com.example.OrdersService.Controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.OrdersService.Dto.MenuItemDto;
import com.example.OrdersService.Dto.PaymentInfoDto;
import com.example.OrdersService.Dto.UserDto;
import com.example.OrdersService.Service.PaymentService;

import freemarker.template.TemplateException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "PaymentController", description = "REST Apis related Payment and order sending details email to delivery team !!!!")
@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@ApiOperation(value = "Payment and order sending details email to delivery team", response = String.class)
	@PostMapping("payment")

	public String Payment(@RequestBody PaymentInfoDto paymentInfoDto)
			throws MailException, IOException, TemplateException, MessagingException {

		return paymentService.Payment(paymentInfoDto);

	}

}
