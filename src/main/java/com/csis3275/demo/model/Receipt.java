package com.csis3275.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "recipt")
public class Receipt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany(mappedBy = "recipt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ReceiptItem> reciptItems = new HashSet<>();
	
	public Receipt() {
		
	}
	
	public Receipt(Set<ReceiptItem> receiptItems) {
		this.reciptItems = receiptItems;
	}

	public Set<ReceiptItem> getReciptItems() {
		return reciptItems;
	}

	public void setReciptItems(Set<ReceiptItem> reciptItems) {
		this.reciptItems = reciptItems;
	}

}
