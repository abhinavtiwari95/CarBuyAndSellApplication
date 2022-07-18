package com.carbuyandsell.service;

import com.carbuyandsell.carentity.CarInfo;
import com.carbuyandsell.customerdetails.UserDetails;
import com.carbuyandsell.repository.CarRepository;
import com.carbuyandsell.repository.IUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService<CustomerDetails> {

	@Autowired
	public IUser userrepo;
	
	@Autowired
	public CarRepository carrepo;
	public UserDetails SaveUserDetails(int custNo,int carNo) {
		UserDetails userd=userrepo.findById(custNo).orElse(null);
		userd.setCust_type(true);
		
		CarInfo c=carrepo.findById(carNo).orElse(null);
		
		List<CarInfo> c1=userd.getCarinfo();
		
		CarInfo cx=new CarInfo();
		cx.setCar_number(c.getCar_number());
		cx.setCar_company(c.getCar_company());
		cx.setCar_model(c.getCar_model());
		cx.setCar_owner(c.getCar_owner());
		cx.setCar_price(c.getCar_price());
		cx.setContact_no(c.getContact_no());
		cx.setIs_Purchased(true);
		
		List<CarInfo> carinfo=new ArrayList();
		carinfo.add(cx);
		
		userd.setCarinfo(carinfo);
		
		System.out.println(userd);
		return userrepo.save(userd);
	}
	
	public UserDetails saveOnlyUser(UserDetails user) {
		
		return userrepo.save(user);
	}

//	public UserDetails SaveUserDetails(UserDetails userdetails) {
//		userdetails.setCust_type(true);
//
//		List<CarInfo> c = userdetails.getCarinfo();
//		
//		CarInfo c1 = c.get(0);
//		c1.setIs_Purchased(true);
//		c.set(0, c1);
//
//		return userrepo.save(userdetails);
//	
	}


