package com.carbuyandsell.controller;

import com.carbuyandsell.buyerDTO.BuyerDTO;
import com.carbuyandsell.discount.Discount;
import com.carbuyandsell.service.DiscountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController {
	@Autowired
	public DiscountService disService;

	@PostMapping("/adddiscount")
	public ResponseEntity<BuyerDTO> discountAdded(@RequestBody Discount AddDiscount) {
		disService.addDiscount(AddDiscount);
		return new ResponseEntity<BuyerDTO>(HttpStatus.CREATED);
	}

	@PutMapping("/updatediscount/{id}")
	public ResponseEntity<BuyerDTO> updateDiscount(@PathVariable("id") int id, @RequestBody Discount UpdateDiscount) {
		disService.updateDiscount(id, UpdateDiscount);
		return ResponseEntity.ok().body(null);
	}

}
