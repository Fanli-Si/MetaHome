package com.csis3275.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@Column(name = "receive_date")
	private Date receive_date; // For simplicity, we can let order date == receive date
	
	@Column(name = "expected_refillment_date")
	private Date exp_ref_date;
	
	//for department, I changed into category, and created a category entity. So we can see in each different department, how many things we have and going to be order
	//Item and Category are one-to-many relationship. many item share one category, but one category can have more than one item
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "order_id", nullable = false)
	@JsonIgnore
	private Order order;
	
	public Item() {
		
	}
	
	public Item(String itemName, String department, double price, String tag, double shelfLife, Date receive_date, Date exp_ref_date ) {
		this.itemName = itemName;
		this.price = price;
		this.tag = tag;
		this.shelfLife = shelfLife;
		this.receive_date = receive_date;
		this.exp_ref_date = exp_ref_date;
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

	public Date getReceive_date() {
		return receive_date;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setReceive_date(Date receive_date) {
		this.receive_date = receive_date;
	}

	public Date getExp_ref_date() {
		return exp_ref_date;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setExp_ref_date(Date exp_ref_date) {
		this.exp_ref_date = exp_ref_date;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
}