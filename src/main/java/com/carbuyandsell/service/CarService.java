package com.carbuyandsell.service;

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

		return ((List<CarInfo>) carrepo.findByIsPurchasedFalse()).stream().map(this::toDTO)
				.collect(Collectors.toList());
	}

	public BuyerDTO toDTO(CarInfo carinfo) {

		BuyerDTO buyerdto = new BuyerDTO();

		buyerdto.setCar_number(carinfo.getCar_number());
		buyerdto.setCar_model(carinfo.getCar_model());
		buyerdto.setCar_company(carinfo.getCar_company());
		buyerdto.setCar_price(carinfo.getCar_price());
		buyerdto.setBuy_year(carinfo.getBuy_year());
		buyerdto.setCar_owner(carinfo.getCar_owner());
		buyerdto.setContact_no(carinfo.getContact_no());
		buyerdto.setManufacture_year(carinfo.getManufacture_year());

		return buyerdto;

	}

	public BuyerDTO Sellcar(CarInfo carinfor) {

		carinfor.setCreated_at(carinfor.getCreated_at().now());

		CarInfo carinfo = carrepo.save(carinfor);

		// Then convert entity to BuerDTO
		BuyerDTO sallerResponse = modelMapper.map(carinfo, BuyerDTO.class);

		return sallerResponse;

	}

	

	public BuyerDTO update(int car_number, CarInfo car) {
		CarInfo update = carrepo.findById(car_number)
				.orElseThrow(() -> new AbortException("Wrong car number is specified"));
		
		car.setCreated_at(update.getCreated_at());
		car.setUpdated_at(car.getUpdated_at().now());
		CarInfo carinfo = carrepo.save(car);

		// Then convert entity to BuerDTO
		BuyerDTO updateResponse = modelMapper.map(carinfo, BuyerDTO.class);

		return updateResponse;

	}
}
