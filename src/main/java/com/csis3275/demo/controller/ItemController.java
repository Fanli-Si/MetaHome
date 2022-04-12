package com.csis3275.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csis3275.demo.model.Item;
import com.csis3275.demo.model.ItemRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ItemController {
	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("/items")
	public ResponseEntity<List<Item>> getAllItems(@RequestParam(required = false)String itemName){
		try {
			List<Item> item = new ArrayList<Item>();
			
			if (itemName == null)
				itemRepository.findAll().forEach(item::add);
			else
				itemRepository.findByItemName(itemName).forEach(item::add);
			
			if(item.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(item,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}