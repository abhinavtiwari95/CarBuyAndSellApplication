package com.carbuyandsell.service;

import com.carbuyandsell.buyerDTO.BuyerDTO;
import com.carbuyandsell.carentity.CarInfo;
import com.carbuyandsell.discount.Discount;
import com.carbuyandsell.repository.CarInfoRepo;
import com.carbuyandsell.repository.UserInfoRepo;
import com.carbuyandsell.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.bridge.AbortException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	public UserInfoRepo userrepo;

	@Autowired
	public CarInfoRepo carrepo;

	@Autowired
	public DiscountService disservice;
	
	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	public UserService userservice;

	// For Buying Car
	public UserDetails BuyCarWithUserDetails(int user_id, int carNo) {
		
		
		UserDetails userdetails = userrepo.findById(user_id)
				.orElseThrow(() -> new AbortException("Couldn't get any user_id"));
		userdetails.setUser_type(true);


		if (userdetails.isUser_type() == true) {
			userdetails.setCount_purchased(userdetails.getCount_purchased() + 1);

		}

		CarInfo carinfoget = carrepo.findById(carNo)
				.orElseThrow(() -> new AbortException("Couldn't get any car number"));

		CarInfo carinfo = new CarInfo();
		carinfo.setCar_number(carinfoget.getCar_number());
		carinfo.setCar_company(carinfoget.getCar_company());
		carinfo.setCar_model(carinfoget.getCar_model());
		carinfo.setCar_owner(carinfoget.getCar_owner());
		carinfo.setCar_price(carinfoget.getCar_price());
		carinfo.setContact_no(carinfoget.getContact_no());
		carinfo.setManufacture_year(carinfoget.getManufacture_year());
		carinfo.setBuy_year(carinfoget.getBuy_year());
		carinfo.setCreated_at(carinfoget.getCreated_at());
		carinfo.setUpdated_at(carinfoget.getUpdated_at());
		carinfo.setBuy_at(carinfoget.getBuy_at().now());
		carinfo.setPurchased(true);
/**
 * Gating discount value 
 */
		int discount;
		int count = 0;
		switch (userdetails.getCount_purchased()) {
			case 1:
				List<Discount> firstdis = disservice.getDiscountRecrod();
				count = firstdis.size()-1;
				discount = firstdis.get(count).getFirst_time_dis();

				carinfo.setDiscount_price(carinfoget.getCar_price() - (carinfoget.getCar_price() * discount) / 100);

				break;
			case 2:
				List<Discount> seconddis = disservice.getDiscountRecrod();
				count = seconddis.size()-1;
				discount = seconddis.get(count).getSecond_time_dis();

				carinfo.setDiscount_price(carinfoget.getCar_price() - (carinfoget.getCar_price() * discount) / 100);
				break;
			case 3:
				List<Discount> thirddis = disservice.getDiscountRecrod();
				count = thirddis.size()-1;
				discount = thirddis.get(count).getThird_time_dis();

				carinfo.setDiscount_price(carinfoget.getCar_price() - (carinfoget.getCar_price() * discount) / 100);

				break;
			default:
				break;
		}


		List<CarInfo> carinfolist = new ArrayList<>();
		carinfolist.add(carinfo);
		userdetails.getCarinfo().addAll(carinfolist);

		return userrepo.save(userdetails);
	}

	// Saving User Details
	public UserDetails saveOnlyUser(UserDetails user) {
		
		user.setCreated_at(user.getCreated_at().now());
		UserDetails userdetails = userrepo.save(user);
		// Converting the entity to DTO
		UserDetails buyerdtoResponce = modelMapper.map(userdetails, UserDetails.class);
		
		return buyerdtoResponce;

	}
	/*
	 * Buy the car
	 */
	public UserDetails buyer(int user_id, int carNo, UserDetails userdetail) {
		CarInfo carInfo = carrepo.findById(carNo).orElseThrow(() -> new AbortException("Wrong car number is provided"));

		if (carInfo.isPurchased() != true) {
			carInfo.setPurchased(false);
		}
		userdetail = userrepo.findById(user_id)
				.orElseThrow(() -> new AbortException("Wrong User number is specified in HEADERS"));

		if (userdetail.isUser_type() == false) {
			carInfo.setPurchased(true);
		}

		return userrepo.save(userdetail);
	}
/*
 * updating user details
 */
	public BuyerDTO updateUserDetails(int user_id, UserDetails userDetails) {
		UserDetails update = userrepo.findById(user_id)
				.orElseThrow(() -> new AbortException("Wrong user_id is specified"));
		update.setUser_name(userDetails.getUser_name());
		update.setUser_contact_no(userDetails.getUser_contact_no());
		update.setUser_name(userDetails.getUser_name());
		update.setUpdate_at(userDetails.getUpdate_at().now());
		UserDetails userdetails = userrepo.save(update);

		// Then convert entity to BuerDTO
		BuyerDTO buyerResponse = modelMapper.map(userdetails, BuyerDTO.class);

		return buyerResponse;
	}
}
