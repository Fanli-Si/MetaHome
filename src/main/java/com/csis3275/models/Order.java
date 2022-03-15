package com.csis3275.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "totalCost")
	private double totalCost;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "items")
	private int itemIds[];
	
	public Order(int quantity, double totalCost, int userId, int itemIds[]) {
		this.itemIds = itemIds;
		this.userId = userId;
		this.totalCost = totalCost;
		this.quantity = quantity;
		
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int[] getItemIds() {
		return itemIds;
	}

	public void setItemIds(int[] itemIds) {
		this.itemIds = itemIds;
	}
	

}
