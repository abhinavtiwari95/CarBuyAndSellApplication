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
	public ModelMapper modelMapper;

	@Autowired
	public CarService carservice;

	@GetMapping("/fetchcar")
	public List<BuyerDTO> getlistofcar() {

		return carservice.getlistofcar();
	}

	@PostMapping("/sellcardetails")
	public ResponseEntity<BuyerDTO> sellcardetails(@RequestBody BuyerDTO buyerDto) {

		// First convert BuerDTO to Entity by using ModelMapperClass
		CarInfo carRequest = modelMapper.map(buyerDto, CarInfo.class);

		CarInfo carinfo = carservice.Sellcar(carRequest);

		// Then convert entity to BuerDTO
		BuyerDTO buyerResponse = modelMapper.map(carinfo, BuyerDTO.class);

		return new ResponseEntity<BuyerDTO>(buyerResponse, HttpStatus.CREATED);
	}

	@PutMapping("/update/{car_number}")
	public ResponseEntity<BuyerDTO> updateDetails(@PathVariable("car_number") int car_number,
			@RequestBody BuyerDTO buyerDto) {

		// First convert BuerDTO to Entity by using ModelMapperClass
		CarInfo postRequest = modelMapper.map(buyerDto, CarInfo.class);

		CarInfo carinfo = carservice.update(car_number, postRequest);

		// Then convert entity to BuerDTO
		BuyerDTO buyerResponse = modelMapper.map(carinfo, BuyerDTO.class);

		return ResponseEntity.ok().body(buyerResponse);
	}

}
