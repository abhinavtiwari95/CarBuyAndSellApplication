package com.carbuyandsell.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.carbuyandsell.buyerDTO.BuyerDTO;
import com.carbuyandsell.carentity.CarInfo;
import com.carbuyandsell.repository.CarInfoRepo;
import com.carbuyandsell.repository.UserInfoRepo;
import com.carbuyandsell.userdetails.UserDetails;

import org.aspectj.bridge.AbortException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	
	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public CarInfoRepo carrepo;

	@Autowired
	public UserInfoRepo userrepo;

	public List<BuyerDTO> getlistofcar() {

		return ((List<CarInfo>) carrepo.findByIsPurchasedTrue()).stream().map(this::toDTO).collect(Collectors.toList());
	}

	public BuyerDTO toDTO(CarInfo carinfo) {

		BuyerDTO buyerdto = new BuyerDTO();

		buyerdto.setCar_number(carinfo.getCar_number());
		buyerdto.setCar_model(carinfo.getCar_model());
		buyerdto.setCar_company(carinfo.getCar_company());
		buyerdto.setCar_price(carinfo.getCar_price());
		buyerdto.setYear(carinfo.getYear());
		buyerdto.setCar_owner(carinfo.getCar_owner());
		buyerdto.setContact_no(carinfo.getContact_no());
		buyerdto.setCreated_at(carinfo.getCreated_at());

		return buyerdto;

	}

	public CarInfo Sellcar(CarInfo c) {
		BuyerDTO buyerDto = new BuyerDTO();
		// First convert BuerDTO to Entity by using ModelMapperClass
		CarInfo carRequest = modelMapper.map(buyerDto, CarInfo.class);
		c.setCreated_at(c.getCreated_at().now());
		CarInfo carinfo = carrepo.save(c);

		// Then convert entity to BuerDTO
		BuyerDTO buyerResponse = modelMapper.map(carinfo, BuyerDTO.class);

		return carinfo;

	}

	public UserDetails buyer(int user_contact_no, int carNo, UserDetails userdetail) {
		CarInfo carInfo = carrepo.findById(carNo).orElseThrow(() -> new AbortException("Wrong car number is provided"));
	
		if (carInfo.isPurchased() != true) {
			carInfo.setPurchased(false);
		}
		userdetail = userrepo.findById(user_contact_no)
				.orElseThrow(() -> new AbortException("Wrong User number is specified in HEADERS"));

		if (userdetail.isUser_type() == false) {
			carInfo.setPurchased(true);
		}
		
		return userrepo.save(userdetail);
	}

	public CarInfo update(int car_number, CarInfo car) {
		BuyerDTO buyerDto = new BuyerDTO();

		CarInfo update = carrepo.findById(car_number)
				.orElseThrow(() -> new AbortException("Wrong car number is specified"));
		
		// First convert BuerDTO to Entity by using ModelMapperClass
				CarInfo postRequest = modelMapper.map(buyerDto, CarInfo.class);
				car.setUpdated_at(car.getUpdated_at().now());
				CarInfo carinfo = carrepo.save(car);

				// Then convert entity to BuerDTO
				BuyerDTO buyerResponse = modelMapper.map(carinfo, BuyerDTO.class);


//		update.setCar_company(car.getCar_company());
//		update.setCar_model(car.getCar_model());
//		update.setCar_number(car.getCar_number());
//		update.setCar_owner(car.getCar_owner());
//		update.setCar_price(car.getCar_price());
//		update.setContact_no(car.getContact_no());
//		update.setManufacture_year(car.getManufacture_year());
//		update.setYear(car.getYear());
//		update.setCreated_at(update.getCreated_at());
//		

		return carinfo;

	}
}
