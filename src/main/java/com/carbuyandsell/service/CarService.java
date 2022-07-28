package com.carbuyandsell.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.carbuyandsell.buyerDTO.BuyerDTO;
import com.carbuyandsell.carentity.CarInfo;
import com.carbuyandsell.discount.Discount;
import com.carbuyandsell.repository.CarInfoRepo;
import com.carbuyandsell.repository.UserInfoRepo;
import com.carbuyandsell.userdetails.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	@Autowired
	public CarInfoRepo carrepo;

	@Autowired
	public UserInfoRepo userrepo;

	public List<BuyerDTO> getlistofcar() {

		return ((List<CarInfo>) carrepo.getAllCar()).stream().map(this::toDTO).collect(Collectors.toList());
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
		CarInfo ci = new CarInfo();
		ci.setCar_number(c.getCar_number());
		ci.setCar_company(c.getCar_company());
		ci.setCar_model(c.getCar_model());
		ci.setManufacture_year(c.getManufacture_year());
		ci.setCar_owner(c.getCar_owner());
		ci.setCar_price(c.getCar_price());
		ci.setYear(c.getYear());
		ci.setContact_no(c.getContact_no());
		ci.setCreated_at(c.getCreated_at().now());
		return carrepo.save(ci);

	}

	public UserDetails buyer(int UserId, int carNo, UserDetails userdetail) {
		CarInfo carInfo = carrepo.findById(carNo).orElse(null);
		System.out.println(carInfo);
		if (carInfo.isIs_Purchased() != true) {
			carInfo.setIs_Purchased(false);
		}
		userdetail = userrepo.findById(UserId).orElseThrow(null);

		if (userdetail.isUser_type() == false) {
			carInfo.setIs_Purchased(true);
		}
		return userrepo.save(userdetail);
	}

	public CarInfo update(int car_number, CarInfo car) {

		CarInfo update = carrepo.findById(car_number).get();
		try {
			if (update != null) {
				update.setCar_company(car.getCar_company());
				update.setCar_model(car.getCar_model());
				update.setCar_number(car.getCar_number());
				update.setCar_owner(car.getCar_owner());
				update.setCar_price(car.getCar_price());
				update.setContact_no(car.getContact_no());
				update.setManufacture_year(car.getManufacture_year());
				update.setYear(car.getYear());
				update.setCreated_at(update.getCreated_at());
				update.setUpdated_at(LocalDateTime.now());
			}
		} catch (Exception e) {
			System.out.println("No Data Present with this carno");
		}
		return carrepo.save(update);

	}
	
	

}
