package com.carbuyandsell.repository;

import java.util.List;

import com.carbuyandsell.carentity.CarInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInfoRepo extends JpaRepository<CarInfo, Integer> {

	// if is_Purchased is 1 this means car has been bought.
																// if is_Purchased is 0 this means ready for sell.
	List<CarInfo> findByIsPurchasedFalse();

}
