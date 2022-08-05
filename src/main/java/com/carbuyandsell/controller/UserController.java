package com.carbuyandsell.controller;

import com.carbuyandsell.buyerDTO.BuyerDTO;
import com.carbuyandsell.service.UserService;
import com.carbuyandsell.userdetails.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	public UserService userservice;

// Added the BuyDTO class for PostMapping to save user details
	@PostMapping("/saveuser")
	public ResponseEntity<BuyerDTO> savedetailes(@RequestBody UserDetails user) {
		userservice.saveOnlyUser(user);
		return new ResponseEntity<BuyerDTO>(HttpStatus.CREATED);
	}

// Added the BuyDTO class for PostMapping to buy a car
	@PostMapping("/buy/{carno}")
	public UserDetails buyCar(@RequestHeader("User_id") int user_id, @PathVariable("carno") int carno) {
		return userservice.BuyCarWithUserDetails(user_id, carno);

	}

// Added the BuyDTO class for PutMapping to update the UserDetails 
	@PutMapping("/updateuser/{user_id}")
	public ResponseEntity<BuyerDTO> updateDetails(@PathVariable("user_id") int user_id,
			@RequestBody UserDetails userDetails) {
		userservice.updateUserDetails(user_id, userDetails);
		return ResponseEntity.ok().body(null);
	}

}
