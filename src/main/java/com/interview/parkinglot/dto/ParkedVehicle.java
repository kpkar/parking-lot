package com.interview.parkinglot.dto;

import java.util.Date;

public class ParkedVehicle {

	private String vehicleType;
	private Integer vehicleNumber;
	private Date incomingTime;
	private Date outGoingTime;

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Integer getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(Integer vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Date getIncomingTime() {
		return incomingTime;
	}

	public void setIncomingTime(Date incomingTime) {
		this.incomingTime = incomingTime;
	}

	public Date getOutGoingTime() {
		return outGoingTime;
	}

	public void setOutGoingTime(Date outGoingTime) {
		this.outGoingTime = outGoingTime;
	}

}
