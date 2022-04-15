package com.csis3275.demo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecieptRepository extends JpaRepository<Receipt, Long> {

	List<Receipt> findByReceiptDate(Date receipt_date);

}