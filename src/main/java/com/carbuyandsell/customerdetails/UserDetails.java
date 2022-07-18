package com.carbuyandsell.customerdetails;

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
	
	private int cust_contact_no;
	private String cust_name;
	private String cust_address;
	private boolean cust_type=Boolean.FALSE;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<CarInfo> carinfo = new ArrayList<CarInfo>();
	
	public List<CarInfo> getCarinfo() {
		return carinfo;
	}
	public void setCarinfo(List<CarInfo> carinfo) {
		this.carinfo = carinfo;
	}
	public boolean isCust_type() {
		return cust_type;
	}
	public void setCust_type(boolean cust_type) {
		this.cust_type = cust_type;
	}
	public int getCust_contact_no() {
		return cust_contact_no;
	}
	public void setCust_contact_no(int cust_contact_no) {
		this.cust_contact_no = cust_contact_no;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	

}
