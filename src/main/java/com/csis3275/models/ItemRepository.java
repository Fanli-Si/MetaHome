package com.csis3275.models;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
		
	List<Item> findByItemName(String name);
	List<Item> findByCost(double cost);
	List<Item> findByDepartment(String department);
}
