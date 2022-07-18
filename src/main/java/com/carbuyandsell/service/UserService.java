package com.carbuyandsell.service;

import com.carbuyandsell.carentity.CarInfo;
import com.carbuyandsell.customerdetails.UserDetails;
import com.carbuyandsell.repository.CarRepository;
import com.carbuyandsell.repository.IUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService<CustomerDetails> {

	@Autowired
	public IUser userrepo;
	
	@Autowired
	public CarRepository carrepo;

	public UserDetails SaveUserDetails(UserDetails userdetails) {
		userdetails.setCust_type(true);

		List<CarInfo> c = userdetails.getCarinfo();
		
		CarInfo c1 = c.get(0);
		c1.setIs_Purchased(true);
		c.set(0, c1);

		return userrepo.save(userdetails);
	}

}
