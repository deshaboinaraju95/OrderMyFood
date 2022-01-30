package com.example.OrdersService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.OrdersService.Pojo.CreditCardInfo;

@Repository
public interface CreditCardRepo  extends JpaRepository<CreditCardInfo, Long>{

}
