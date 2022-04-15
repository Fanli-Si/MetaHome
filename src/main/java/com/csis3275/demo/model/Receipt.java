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

@Entity
@Table(name = "receipts")
public class Receipt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "receipt_date")
	private Date receipt_date;

	@Column(name = "total_cost")
	private double total_cost;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(mappedBy = "receipt")
	private Set<ReceiptItem> receiptItems = new HashSet<ReceiptItem>();

	public Receipt() {

	}

	public Receipt(Date rec_date, double cost) {
		this.receipt_date = rec_date;
		this.total_cost = cost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getReceipt_date() {
		return receipt_date;
	}

	public void setReceipt_date(Date receipt_date) {
		this.receipt_date = receipt_date;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<ReceiptItem> getReceiptItems() {
		return receiptItems;
	}

	public void setReceiptItems(Set<ReceiptItem> receiptItems) {
		this.receiptItems = receiptItems;
	}

	public void addReceiptItems(ReceiptItem receitpItem) {
		this.receiptItems.add(receitpItem);
	}

}
