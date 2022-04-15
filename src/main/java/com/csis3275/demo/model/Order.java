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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
public class Order {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "order_number")
	private int order_number;

	@Column(name = "item_number")
	private String item_number;

	@Column(name = "item_title")
	private String item_title;
	
	@Column(name = "order_date")
	private Date order_date;
	
	@Column(name = "tracking_number")
	private int tracking_number;

	
	@ManyToOne
	private User user;

	
	public Order() {

	}

	public Order(int order_number, String item_number, String item_title, Date order_date, int tracking_number) {
		this.order_number = order_number;
		this.item_number = item_number;
		this.item_title = item_title;
		this.order_date = order_date;
		this.tracking_number = tracking_number;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	public String getItem_number() {
		return item_number;
	}

	public void setItem_number(String item_number) {
		this.item_number = item_number;
	}

	public String getItem_title() {
		return item_title;
	}

	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}

	public Date getOrder_date() {
		return order_date;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getTracking_number() {
		return tracking_number;
	}

	public void setTracking_number(int tracking_number) {
		this.tracking_number = tracking_number;
	}


}
