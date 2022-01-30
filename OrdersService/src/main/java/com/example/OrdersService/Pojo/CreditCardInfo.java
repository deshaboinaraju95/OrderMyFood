
package com.example.OrdersService.Pojo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Entity
public class CreditCardInfo {
	
	@Id
	@GeneratedValue
	private Long CraditCardId;
    private String firstName;
    private String lastName;
    private Integer expiredMonth;
    private Integer expiredYear;
    private Integer securityCode;
	public Long getCraditCardId() {
		return CraditCardId;
	}
	public void setCraditCardId(Long craditCardId) {
		CraditCardId = craditCardId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getExpiredMonth() {
		return expiredMonth;
	}
	public void setExpiredMonth(Integer expiredMonth) {
		this.expiredMonth = expiredMonth;
	}
	public Integer getExpiredYear() {
		return expiredYear;
	}
	public void setExpiredYear(Integer expiredYear) {
		this.expiredYear = expiredYear;
	}
	public Integer getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}
	
}
