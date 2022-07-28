package com.carbuyandsell.controller;

import com.carbuyandsell.buyerDTO.BuyerDTO;
import com.carbuyandsell.service.UserService;
import com.carbuyandsell.userdetails.UserDetails;

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
	public ResponseEntity<BuyerDTO> savedetailes(@RequestBody UserDetails user) {

		// Converting the DTO to entity
		UserDetails userRequest = modelMapper.map(user, UserDetails.class);

		UserDetails userdetails = userservice.saveOnlyUser(userRequest);

		// Converting the entity to DTO
		UserDetails buyerdtoResponce = modelMapper.map(userdetails, UserDetails.class);

		return new ResponseEntity<BuyerDTO>(HttpStatus.CREATED);
	}

	@PostMapping("/buy/{carno}")
	public UserDetails buyCar(@RequestHeader("User_Contact_No") int user_contact_no, @PathVariable("carno") int carno) {
		return userservice.SaveUserDetails(user_contact_no, carno);

	}

}
