package com.carbuyandsell.controller;

import com.carbuyandsell.discount.Discount;
import com.carbuyandsell.service.DiscountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController {
	@Autowired
	public DiscountService disService;
	
	@PostMapping("/discount")
	public Discount getDiscount(Discount dis) {
		return disService.getDiscount(dis);
	}

}
