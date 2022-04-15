package com.csis3275.demo.model;

import java.util.HashSet;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
	@Column(name = "tag")
	private String tag;
	
	@Column(name = "shelfLife") // Not sure about what tags does. For our purpose, I think maybe we can add shelf_life for it for reminder expectation 
	private double shelfLife;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "category_id", nullable = false)
	@JsonIgnore
	private Category category;
	
	@OneToMany(mappedBy = "item")
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	
	@OneToMany(mappedBy = "item")
	private Set<ReceiptItem> receiptItems = new HashSet<ReceiptItem>();
	
	
	public Item() {
		
	}
	
	public Item(String itemName, double price, String tag, double shelfLife) {
		this.itemName = itemName;
		this.price = price;
		this.tag = tag;
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

	public void setPrice(double price) {
		this.price = price;
	}

	public double getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(double shelfLife) {
		this.shelfLife = shelfLife;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Set<ReceiptItem> getReceiptItems() {
		return receiptItems;
	}

	public void setReceiptItems(Set<ReceiptItem> receiptItems) {
		this.receiptItems = receiptItems;
	}
	
	
}