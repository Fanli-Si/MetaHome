package com.csis3275.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemId;
	
	@Column(name = "itemName")
	private String itemName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "cost")
	private double cost;
	
	@Column(name = "tags")
	private String tags;
	
	public Item() {
		
	}
	
	public Item(String itemName, String department, double cost, String tags) {
		this.itemName = itemName;
		this.department = department;
		this.cost = cost;
		this.tags = tags;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}