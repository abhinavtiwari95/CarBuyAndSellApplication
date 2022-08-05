package com.carbuyandsell.userdetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.carbuyandsell.carentity.CarInfo;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	private int user_contact_no;
	private String user_name;
	private String user_address;
	private int count_purchased;
	private LocalDateTime created_at;
	private LocalDateTime update_at;
	private boolean user_type = Boolean.FALSE;

	@OneToMany(cascade = CascadeType.ALL)
	private List<CarInfo> carinfo = new ArrayList<CarInfo>();

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getUser_contact_no() {
		return user_contact_no;
	}

	public void setUser_contact_no(int user_contact_no) {
		this.user_contact_no = user_contact_no;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public boolean isUser_type() {
		return user_type;
	}

	public void setUser_type(boolean user_type) {
		this.user_type = user_type;
	}

	public List<CarInfo> getCarinfo() {
		return carinfo;
	}

	public void setCarinfo(List<CarInfo> carinfo) {
		this.carinfo = carinfo;
	}


	public int getCount_purchased() {
		return count_purchased;
	}

	public void setCount_purchased(int count_purchased) {
		this.count_purchased = count_purchased;
	}

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

}
