package com.carbuyandsell.service;

import com.carbuyandsell.carentity.CarInfo;
import com.carbuyandsell.discount.Discount;
import com.carbuyandsell.repository.CarInfoRepo;
import com.carbuyandsell.repository.UserInfoRepo;
import com.carbuyandsell.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	public UserInfoRepo userrepo;

	@Autowired
	public Discount dis;
	
	@Autowired
	public CarInfoRepo carrepo;

	public UserDetails SaveUserDetails(int custNo, int carNo) {

		UserDetails userdetails = userrepo.findById(custNo).orElse(null);
		userdetails.setUser_type(true);
		
		if(userdetails.isUser_type()==true) {
			userdetails.setCount_purchased(userdetails.getCount_purchased()+1);
		}

		CarInfo carinfoget = carrepo.findById(carNo).orElse(null);

		CarInfo carinfo = new CarInfo();
		carinfo.setCar_number(carinfoget.getCar_number());
		carinfo.setCar_company(carinfoget.getCar_company());
		carinfo.setCar_model(carinfoget.getCar_model());
		carinfo.setCar_owner(carinfoget.getCar_owner());
		carinfo.setCar_price(carinfoget.getCar_price());
		carinfo.setContact_no(carinfoget.getContact_no());
		carinfo.setIs_Purchased(true);

		switch (userdetails.getCount_purchased()) {
			case 1:
				carinfo.setDiscount_price(carinfoget.getCar_price() - (carinfoget.getCar_price() * dis.getFirst_time_dis()) / 100);
				break;
			default:
				break;
		}
		

		List<CarInfo> carinfo1 = new ArrayList<>();
		carinfo1.add(carinfo);
		userdetails.getCarinfo().addAll(carinfo1);

		return userrepo.save(userdetails);
	}

	public UserDetails saveOnlyUser(UserDetails user) {

		return userrepo.save(user);

	}
}
