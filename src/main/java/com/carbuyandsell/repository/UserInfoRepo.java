package com.carbuyandsell.repository;

import com.carbuyandsell.customerdetails.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepo extends JpaRepository<UserDetails, Integer> {
	
	

}
