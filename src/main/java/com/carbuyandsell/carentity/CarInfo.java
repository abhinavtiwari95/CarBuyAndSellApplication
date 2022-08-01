package com.carbuyandsell.carentity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarInfo {
	@Id
	
	private int car_number;
	private int car_model;
	private int manufacture_year;
	private String car_company;
	private String car_owner;
	private int car_price;
	private int contact_no;
	private int year;
	private int discount_price;
	
	private boolean isPurchased=Boolean.FALSE;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private LocalDateTime buy_at;

	public int getContact_no() {
		return contact_no;
	}

	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}



	public boolean isPurchased() {
		return isPurchased;
	}

	public void setPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}

	public int getCar_number() {
		return car_number;
	}

	public void setCar_number(int car_number) {
		this.car_number = car_number;
	}

	public int getCar_model() {
		return car_model;
	}

	public void setCar_model(int car_model) {
		this.car_model = car_model;
	}

	public int getManufacture_year() {
		return manufacture_year;
	}

	public void setManufacture_year(int manufacture_year) {
		this.manufacture_year = manufacture_year;
	}

	public String getCar_company() {
		return car_company;
	}

	public void setCar_company(String car_company) {
		this.car_company = car_company;
	}

	public String getCar_owner() {
		return car_owner;
	}

	public void setCar_owner(String car_owner) {
		this.car_owner = car_owner;
	}

	public int getCar_price() {
		return car_price;
	}

	public void setCar_price(int car_price) {
		this.car_price = car_price;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	public LocalDateTime getBuy_at() {
		return buy_at;
	}

	public void setBuy_at(LocalDateTime buy_at) {
		this.buy_at = buy_at;
	}

	public int getDiscount_price() {
		return discount_price;
	}

	public void setDiscount_price(int discount_price) {
		this.discount_price = discount_price;
	}

	public LocalDateTime getBuy_at() {
		return buy_at;
	}

	public void setBuy_at(LocalDateTime buy_at) {
		this.buy_at = buy_at;
	}


}
