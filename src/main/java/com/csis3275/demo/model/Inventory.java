package com.csis3275.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Inventory") // for each user, they will have an inventory to store what they have in stock
							// and track the refillment date
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne(mappedBy = "inventory")
	private User user;

	private OrderItem orderItem;
	private ReceiptItem receiptItem;

	// Additional fields
	@Column(name = "Reminder_Date")
	private double reminder_date = orderItem.getExp_duration()
			+ Double.parseDouble(orderItem.getExp_rec_date().toString());

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderItem_ID")
	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ReceiptItem_ID")
	public ReceiptItem getReceiptItem() {
		return receiptItem;
	}

	public void setReceiptItem(ReceiptItem receiptItem) {
		this.receiptItem = receiptItem;
	}

}
