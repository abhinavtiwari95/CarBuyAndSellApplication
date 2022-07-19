package com.carbuyandsell.controller;

import com.carbuyandsell.buyerDTO.BuyerDTO;
import com.carbuyandsell.customerdetails.UserDetails;
import com.carbuyandsell.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	public UserService userservice;
	
	@Autowired
	public ModelMapper modelMapper;

	
	@PostMapping("/saveuser")
	public ResponseEntity<BuyerDTO> savedetailes(@RequestBody BuyerDTO buyerdto) {
		
		//Converting the DTO to entity
		UserDetails userRequest = modelMapper.map(buyerdto, UserDetails.class);
		
		UserDetails userdetails = userservice.saveOnlyUser(userRequest);
		
		//Converting the entity to DTO
		BuyerDTO buyerdtoResponce = modelMapper.map(userdetails, BuyerDTO.class);
		
		return new ResponseEntity<BuyerDTO>(buyerdtoResponce, HttpStatus.CREATED);
	}

	@PostMapping("/buy/{carno}")
	public UserDetails buyCar(@RequestHeader("User_Contact_No") int userid, @PathVariable("carno") int carno) {
		return userservice.SaveUserDetails(userid, carno);

	}


}
