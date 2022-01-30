package com.example.OrdersService.Dto;


public class PaymentInfoDto {
	
	private Long orderId;
	private Double amount;
	private Long craditCardId;
    private Integer expiredMonth;
    private Integer expiredYear;
    private Integer securityCode;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Long getCraditCardId() {
		return craditCardId;
	}
	public void setCraditCardId(Long craditCardId) {
		this.craditCardId = craditCardId;
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
	@Override
	public String toString() {
		return "PaymentInfoDto [orderId=" + orderId + ", amount=" + amount + ", craditCardId=" + craditCardId
				+ ", expiredMonth=" + expiredMonth + ", expiredYear=" + expiredYear + ", securityCode=" + securityCode
				+ "]";
	}
	
}
