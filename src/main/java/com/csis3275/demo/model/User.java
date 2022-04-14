package com.csis3275.demo.model;

import java.util.HashSet;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "userId")
	private String userId;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Order> orders = new HashSet<>();
	
	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Receipt> receipts = new HashSet<>();
	
	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Inventory> inventory = new HashSet<>();


	public User() {
		
	}
	
	public User(String userId, String name, String password) {
		this.userId = userId;
		this.name = name; 
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
	public Set<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(Set<Receipt> receipts) {
		this.receipts = receipts;
	}
	

	public Set<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
		order.getUser().add(this);
		
	}

	public void removeOrder(Order order) {
		order.getUser().remove(this);
		this.orders.remove(order);
	}
	


}
