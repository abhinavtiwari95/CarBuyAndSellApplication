package com.carbuyandsell.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.carbuyandsell.discount.Discount;
import com.carbuyandsell.repository.DiscountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
	
	@Autowired
	public DiscountRepo disrepo;
	
	public Discount getDiscount(Discount discount) {
		Discount dis = new Discount();
		dis.setCreatedAt(discount.getCreatedAt().now());
		dis.setFirst_time_dis(discount.getFirst_time_dis());
		dis.setSecond_time_dis(discount.getSecond_time_dis());
		dis.setThird_time_dis(discount.getThird_time_dis());
		
		return disrepo.save(dis);
		
	}
	
	public Discount updateDiscount(int list_no, Discount discount) {
		Discount getdis = disrepo.findById(list_no).orElseThrow();
		
		getdis.setFirst_time_dis(discount.getFirst_time_dis());
		getdis.setSecond_time_dis(discount.getSecond_time_dis());
		getdis.setThird_time_dis(discount.getThird_time_dis());
		getdis.setUpdatedAt(discount.getUpdatedAt().now());
		
		return disrepo.save(getdis);
		
	}
	
	public List<Discount> getDiscountRecrod() {
		
		return disrepo.findAll();
		
	}

}
