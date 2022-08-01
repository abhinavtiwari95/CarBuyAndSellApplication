package com.carbuyandsell.service;

import com.carbuyandsell.carentity.CarInfo;
import com.carbuyandsell.discount.Discount;
import com.carbuyandsell.repository.CarInfoRepo;
import com.carbuyandsell.repository.DiscountRepo;
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
	public DiscountService disser;
	
	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	public UserService userservice;

	public UserDetails SaveUserDetails(int custNo, int carNo) {
		
		
		UserDetails userdetails1 = userrepo.findById(custNo)
				.orElseThrow(() -> new AbortException("Couldn't get any User number"));
		userdetails1.setUser_type(true);

		if (userdetails1.isUser_type() == true) {
			userdetails1.setCount_purchased(userdetails1.getCount_purchased() + 1);
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
		carinfo.setYear(carinfoget.getYear());
		carinfo.setBuy_at(carinfoget.getBuy_at().now());
		carinfo.setPurchased(true);

		int discount;
		switch (userdetails1.getCount_purchased()) {
			case 1:
				List<Discount> firstdis = disser.getDiscountRecrod();
				discount = firstdis.get(0).getFirst_time_dis();

				carinfo.setDiscount_price(carinfoget.getCar_price() - (carinfoget.getCar_price() * discount) / 100);

				break;
			case 2:
				List<Discount> seconddis = disser.getDiscountRecrod();
				discount = seconddis.get(0).getSecond_time_dis();

				carinfo.setDiscount_price(carinfoget.getCar_price() - (carinfoget.getCar_price() * discount) / 100);
				break;
			case 3:
				List<Discount> thirddis = disser.getDiscountRecrod();
				discount = thirddis.get(0).getThird_time_dis();

				carinfo.setDiscount_price(carinfoget.getCar_price() - (carinfoget.getCar_price() * discount) / 100);
				break;
			default:
				break;
		}

		List<CarInfo> carinfo1 = new ArrayList<>();
		carinfo1.add(carinfo);
		userdetails1.getCarinfo().addAll(carinfo1);

		return userrepo.save(userdetails1);
	}

	public UserDetails saveOnlyUser(UserDetails user) {
		
		
		// Converting the DTO to entity
		UserDetails userRequest = modelMapper.map(user, UserDetails.class);
		user.setCreated_at(user.getCreated_at().now());
		UserDetails userdetails = userrepo.save(user);

		//UserDetails userdetails1 = userservice.saveOnlyUser(userRequest);
		// Converting the entity to DTO
		UserDetails buyerdtoResponce = modelMapper.map(userdetails, UserDetails.class);


		return userdetails;

	}
}
