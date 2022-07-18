package com.carbuyandsell.repository;

import com.carbuyandsell.customerdetails.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<UserDetails, Integer> {
	
	

}
