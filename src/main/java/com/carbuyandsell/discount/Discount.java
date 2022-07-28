package com.carbuyandsell.discount;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Discount {
	@Id
	private LocalDateTime createdAt;
	
	private int first_time_dis;

	private int second_time_dis;

	private int third_time_dis;
	
	private LocalDateTime updatedAt;
	
	public int getFirst_time_dis() {
		return first_time_dis;
	}
	public void setFirst_time_dis(int first_time_dis) {
		this.first_time_dis = first_time_dis;
	}
	public int getSecond_time_dis() {
		return second_time_dis;
	}
	public void setSecond_time_dis(int second_time_dis) {
		this.second_time_dis = second_time_dis;
	}
	public int getThird_time_dis() {
		return third_time_dis;
	}
	public void setThird_time_dis(int third_time_dis) {
		this.third_time_dis = third_time_dis;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
