package com.interview.parkinglot.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VehicleRequestDto {

	private String vechicleType;
	private Integer vechicleNumber;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
	private Date incomingTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
	private Date outgoingTime;

	public String getVechicleType() {
		return vechicleType;
	}

	public void setVechicleType(String vechicleType) {
		this.vechicleType = vechicleType;
	}

	public Integer getVechicleNumber() {
		return vechicleNumber;
	}

	public void setVechicleNumber(Integer vechicleNumber) {
		this.vechicleNumber = vechicleNumber;
	}

	public Date getIncomingTime() {
		return incomingTime;
	}

	public void setIncomingTime(Date incomingTime) {
		this.incomingTime = incomingTime;
	}

	public Date getOutgoingTime() {
		return outgoingTime;
	}

	public void setOutgoingTime(Date outgoingTime) {
		this.outgoingTime = outgoingTime;
	}

}
