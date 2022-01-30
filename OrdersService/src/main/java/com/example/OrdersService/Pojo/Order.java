package com.example.OrdersService.Pojo;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderid;

	private Long userfkid;

	/*
	 * @OneToOne(cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="payment_fkId")
	 */
	private Long paymentfkId;
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	/*
	 * @JoinTable( name = "order_OrderItem", joinColumns = @JoinColumn(name =
	 * "order_fkid"), inverseJoinColumns = @JoinColumn(name = "Orderitem_fkid"))
	 */

	@OneToMany(mappedBy = "morder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderItem> mitems;

	// private DeliveryInfo deliveryInfo;
	private double totalCost;
	private String note;
	@CreatedDate
	private Date creationTime;
	@LastModifiedDate
	private Date lastModifyTime;

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getUserfkid() {
		return userfkid;
	}

	public void setUserfkid(Long userfkid) {
		this.userfkid = userfkid;
	}

	public Long getPaymentfkId() {
		return paymentfkId;
	}

	public void setPaymentfkId(Long paymentfkId) {
		this.paymentfkId = paymentfkId;
	}

	public List<OrderItem> getMitems() {
		return mitems;
	}

	public void setMitems(List<OrderItem> mitems) {
		this.mitems = mitems;
	}

	/*
	 * public DeliveryInfo getDeliveryInfo() { return deliveryInfo; } public void
	 * setDeliveryInfo(DeliveryInfo deliveryInfo) { this.deliveryInfo =
	 * deliveryInfo; }
	 */
	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

}
