package com.carbuyandsell.repository;

import java.util.List;

import com.carbuyandsell.carentity.CarInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<CarInfo, Integer> {

	@Query("select c from CarInfo c where c.is_Purchased !=1") // if is_Purchased is 1 this means car has been bought.
																// if is_Purchased is 0 this means ready for sell.
	List<CarInfo> getAllCar();
	


}
