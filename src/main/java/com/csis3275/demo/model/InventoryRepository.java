package com.csis3275.demo.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	List<Inventory> findByInventoryId(long inventoryId);

	List<Inventory> findByReminderDate(double reminderDate);

	Optional<Inventory> findByItemId(long itemId);
}