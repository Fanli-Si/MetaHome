package com.csis3275.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Receipts_Items")
public class ReceiptItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Receipt_Item_ID")
	private long id;

	private Receipt receipt;
	private Item item;

	// additional fields
	@Column(name = "quantity")
	private double quantity;

	@Column(name = "item_cost")
	private double item_cost = this.quantity * item.getPrice();

	@Column(name = "Expected_Duration") // expected duration time is supposed to calculated by historical data, since we
										// don't have any, we can just use simulation data.
	private double exp_duration;

	private Set<Inventory> inventories = new HashSet<Inventory>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Receipt_ID")
	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Item_ID")
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getItem_cost() {
		return item_cost;
	}

	public void setItem_cost(double item_cost) {
		this.item_cost = item_cost;
	}

	public double getExp_duration() {
		return exp_duration;
	}

	public void setExp_duration(double exp_duration) {
		this.exp_duration = exp_duration;
	}

	@OneToMany(mappedBy = "receiptItem")
	public Set<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}

}
