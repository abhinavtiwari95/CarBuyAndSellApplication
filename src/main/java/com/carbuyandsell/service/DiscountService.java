package com.carbuyandsell.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.carbuyandsell.buyerDTO.BuyerDTO;
import com.carbuyandsell.carentity.CarInfo;
import com.carbuyandsell.discount.Discount;
import com.carbuyandsell.repository.DiscountRepo;

import org.aspectj.bridge.AbortException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DiscountService {

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public DiscountRepo discountrepo;
//Adding discount value
	public Discount addDiscount(Discount addDiscount) {
		
		addDiscount.setCreatedAt(addDiscount.getCreatedAt().now());

		Discount discount = discountrepo.save(addDiscount);

		// Then convert entity to BuerDTO
		BuyerDTO discountResponse = modelMapper.map(addDiscount, BuyerDTO.class);

		return discount;

	}
// updating discount value
	public Discount updateDiscount(int id, Discount updateDiscount) {
		Discount getdiscount = discountrepo.findById(id)
				.orElseThrow(() -> new AbortException("Wrong Discount ID is specified"));

		getdiscount.setFirst_time_dis(updateDiscount.getFirst_time_dis());
		getdiscount.setSecond_time_dis(updateDiscount.getSecond_time_dis());
		getdiscount.setThird_time_dis(updateDiscount.getThird_time_dis());
		getdiscount.setUpdatedAt(updateDiscount.getUpdatedAt().now());

		Discount discountUpdate = discountrepo.save(getdiscount);

		// Then convert entity to BuerDTO
		BuyerDTO updateResponse = modelMapper.map(discountUpdate, BuyerDTO.class);

		return discountUpdate;
	}

	public List<Discount> getDiscountRecrod() {

		return discountrepo.findAll();

	}

}
