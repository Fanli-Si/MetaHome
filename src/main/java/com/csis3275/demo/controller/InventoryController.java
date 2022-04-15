package com.csis3275.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csis3275.demo.model.Inventory;
import com.csis3275.demo.model.InventoryRepository;
import com.csis3275.demo.model.Item;
;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class InventoryController {
	@Autowired
	InventoryRepository inventoryRepository;
	
	@GetMapping("/inventory")
	public ResponseEntity<List<Inventory>> getAllInventory(@RequestParam(required = false)Long inventoryId){
		
		try {
			List<Inventory> inventory = new ArrayList<Inventory>();
			
			if (inventoryId == null)
				inventoryRepository.findAll().forEach(inventory::add);
			else
				inventoryRepository.findByInventoryId(inventoryId).forEach(inventory::add);
			
			if(inventory.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(inventory,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/inventory/{uid}")
	public ResponseEntity<Inventory> getInventoryByUserId(@PathVariable("uid") Item item){
		Optional<Inventory> inventoryData = inventoryRepository.findByItemId(item.getItemId());
		
		if (inventoryData.isPresent()) {
			return new ResponseEntity<>(inventoryData.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
}

