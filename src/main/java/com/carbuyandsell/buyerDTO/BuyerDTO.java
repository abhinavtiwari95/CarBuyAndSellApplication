package com.carbuyandsell.buyerDTO;

import java.time.LocalDateTime;

public class BuyerDTO {

	private int car_number;
	private int car_model;
	private String car_company;
	private int Manufacture_year;
	private int car_price;
	private int year;
	private String car_owner;
	private int contact_no;
	private LocalDateTime created_at;
	private LocalDateTime update_at;

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(LocalDateTime update_at) {
		this.update_at = update_at;
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

	public String getCar_company() {
		return car_company;
	}

	public void setCar_company(String car_company) {
		this.car_company = car_company;
	}

	public int getManufacture_year() {
		return Manufacture_year;
	}

	public void setManufacture_year(int manufacture_year) {
		Manufacture_year = manufacture_year;
	}

	public int getCar_price() {
		return car_price;
	}

	public void setCar_price(int car_price) {
		this.car_price = car_price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCar_owner() {
		return car_owner;
	}

	public void setCar_owner(String car_owner) {
		this.car_owner = car_owner;
	}

	public int getContact_no() {
		return contact_no;
	}

	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}

}
