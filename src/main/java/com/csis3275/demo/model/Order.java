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
import javax.persistence.ManyToMany;
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
	private String order_number;

	@Column(name = "item_number")
	private int item_number;

	@Column(name = "item_title")
	private String item_title;
	
	@Column(name = "order_date")
	private Date order_date;
	
	@Column(name = "tracking_number")
	private int tracking_number;

	@JsonIgnore 
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "orders_users", joinColumns = { 
		@JoinColumn(name = "order_number", referencedColumnName = "id") }, inverseJoinColumns = {
		@JoinColumn(name = "userId", referencedColumnName = "id") })
	private Set<User> users = new HashSet<>();

	
	public Order() {

	}

	public Order(String order_number, int item_number, String item_title, Date order_date, int tracking_number) {
		this.order_number = order_number;
		this.item_number = item_number;
		this.item_title = item_title;
		this.order_date = order_date;
		this.tracking_number = tracking_number;
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

	public int getItem_number() {
		return item_number;
	}

	public void setItem_number(int item_number) {
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
