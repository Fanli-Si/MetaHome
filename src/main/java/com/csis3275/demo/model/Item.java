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
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemId;
	
	@Column(name = "itemName")
	private String itemName;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "shelfLife") // Not sure about what tags does. For our purpose, I think maybe we can add shelf_life for it for reminder expectation 
	private double shelfLife;
	
	@Column(name = "receive_date")
	private Date receive_date; // For simplicity, we can let order date == receive date
	
	@Column(name = "expected_refillment_date")
	private Date exp_ref_date;
	
	//for department, I changed into category, and created a category entity. So we can see in each different department, how many things we have and going to be order
	//Item and Category are one-to-many relationship. many item share one category, but one category can have more than one item
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "cat_id", nullable = false)
	private Category category;
	
	public Item() {
		
	}
	
	public Item(String itemName, String department, double price, double shelfLife) {
		this.itemName = itemName;
		this.price = price;
		this.shelfLife = shelfLife;
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


	public double getPrice() {
		return price;
	}

	public void setPrice(double Price) {
		this.price = price;
	}
}