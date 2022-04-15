package com.csis3275.demo.model;

import java.util.Date;


import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orders")
public class Order {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "order_number")
	private String order_number;
	
	@Column(name = "order_date")
	private Date order_date;
	
	@Column(name = "tracking_number")
	private String tracking_number;
	
	@Column(name = "isClose")//to divide the difference between open/current orders and past/close orders
	private boolean close;
	
	@Column(name = "total_cost")
	private double total_cost;
	
	// One order only has one user, so user and order is a one to many relationship, so here we use many to one
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@OneToMany(mappedBy = "order")
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	
	public Order() {

	}

	public Order(String order_number, Date order_date, String tracking_number, Boolean status, double total_cost) {
		this.order_number = order_number;
		this.order_date = order_date;
		this.tracking_number = tracking_number;
		this.close = status;
		this.total_cost = total_cost;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}


	public Date getOrder_date() {
		return order_date;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getTracking_number() {
		return tracking_number;
	}

	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}


	public boolean isClose() {
		return close;
	}

	public void setClose(boolean close) {
		this.close = close;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void addOrderItems(OrderItem orderItem) {
		this.orderItems.add(orderItem);
	}
	

}
