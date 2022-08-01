package com.carbuyandsell.controller;

import com.carbuyandsell.discount.Discount;
import com.carbuyandsell.service.DiscountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController {
	@Autowired
	public DiscountService disService;
	
	@PostMapping("/discount")
	public Discount getDiscount(@RequestBody Discount dis) {
		return disService.getDiscount(dis);
	}
	
	@PutMapping("/updatediscount/{list_no}")
	public Discount updateDiscount(@PathVariable ("list_no") int list_no, @RequestBody Discount updatedis) {
		return disService.updateDiscount(list_no, updatedis);
	}

}
