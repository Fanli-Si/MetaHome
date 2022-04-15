package com.csis3275.demo.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	List<Item> findByItemName(String name);
	List<Item> findByCost(double cost);
	List<Item> findByDepartment(String department);
}
