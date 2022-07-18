package com.carbuyandsell.controller;

import java.util.List;

import com.carbuyandsell.buyerDTO.BuyerDTO;
import com.carbuyandsell.carentity.CarInfo;
import com.carbuyandsell.customerdetails.UserDetails;
import com.carbuyandsell.service.CarService;
import com.carbuyandsell.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	public CarService carservice;
	
	@Autowired
	public UserService userservice;
	

	@GetMapping("/fetchcar")
	public List<BuyerDTO> getlistofcar(){
		
		return carservice.getlistofcar();
	}
	
	@PostMapping("/buy")
	public UserDetails savedetailes(@RequestBody UserDetails userdetails) {
		return userservice.SaveUserDetails(userdetails);
	}
	
	@PostMapping("/sellcardetails")
	public void sellcardetails(@RequestBody CarInfo carinfo) {
		carservice.Sellcar(carinfo);
	}
	
	@PostMapping("/buy/{userid}/{carno}")
	public UserDetails buyCar(@PathVariable("userid") int userid,@PathVariable("carno") int carno,@RequestBody UserDetails userdetails) {
		return carservice.buyer(userid, carno,userdetails);
		
	}
	@PutMapping("/update/{car_number}")
	public CarInfo updateDetails(@PathVariable ("car_number") int car_number, @RequestBody CarInfo car) {
		return carservice.update(car_number, car);
	}
}
