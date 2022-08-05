package com.carbuyandsell.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import com.carbuyandsell.buyerDTO.BuyerDTO;
import com.carbuyandsell.carentity.CarInfo;
import com.carbuyandsell.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
/*
 * fetching available cars
 */
	@GetMapping("/fetchcar")
	public List<BuyerDTO> getlistofcar() {

		return carservice.getlistofcar();
	}
// Add a car for sell
	@PostMapping("/savecardetails")
	public ResponseEntity<BuyerDTO> sellcardetails(@RequestBody CarInfo car) {
		
		return new ResponseEntity<BuyerDTO>(carservice.Sellcar(car),HttpStatus.CREATED);

	}
//update car details
	@PutMapping("/update/{car_number}")
	public ResponseEntity<BuyerDTO> updateDetails(@PathVariable("car_number") int car_number,
			@RequestBody CarInfo carinfo) {
		return ResponseEntity.ok().body(carservice.update(car_number, carinfo));
	}

}
