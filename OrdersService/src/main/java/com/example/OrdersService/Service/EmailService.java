package com.example.OrdersService.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.OrdersService.Dto.DeliveryOrderItemDto;
import com.example.OrdersService.Dto.RestaurantLocationDto;
import com.example.OrdersService.Dto.UserDto;
import com.example.OrdersService.Dto.UserLocationDto;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

@Service
public class EmailService {

    final Configuration configuration;
    final JavaMailSender javaMailSender;

    public EmailService(Configuration configuration, JavaMailSender javaMailSender) {
        this.configuration = configuration;
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(UserDto user ,UserLocationDto userLationdtonDto,List<DeliveryOrderItemDto> deliveryOrderItemDtoList,RestaurantLocationDto restaurantLocationDto, Double total, long l) throws MailException, IOException, TemplateException, MessagingException {
       MimeMessage meMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(meMessage);
        helper.setSubject("Order Detailes");
        helper.setTo(user.getEmilId());
        String emailContent = getEmailContent(user,userLationdtonDto,deliveryOrderItemDtoList,restaurantLocationDto,total,l);
        helper.setText(emailContent, true);
        javaMailSender.send(meMessage);
    }

    String getEmailContent(UserDto user ,UserLocationDto userLationdtonDto,List<DeliveryOrderItemDto> deliveryOrderItemDtoList,RestaurantLocationDto restaurantLocationDto, Double total,long l) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        model.put("userlocation", userLationdtonDto);
        model.put("itemlist", deliveryOrderItemDtoList);  
        model.put("restaurantandlocation", restaurantLocationDto);
        model.put("charges", l);
        model.put("total", total);
        
        configuration.getTemplate("email.ftlh").process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}