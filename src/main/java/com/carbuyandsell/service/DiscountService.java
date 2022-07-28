package com.carbuyandsell.service;

import com.carbuyandsell.discount.Discount;
import com.carbuyandsell.repository.DiscountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
	
	@Autowired
	public DiscountRepo disrepo;
	
	public Discount getDiscount(Discount discount) {
		
		discount.setCreatedAt(discount.getCreatedAt().now());
		discount.setFirst_time_dis(discount.getFirst_time_dis());
		discount.setSecond_time_dis(discount.getSecond_time_dis());
		discount.setThird_time_dis(discount.getThird_time_dis());
		
		return disrepo.save(discount);
		
	}

}
