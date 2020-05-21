package com.interview.parkinglot.dto;

public class SlotDto {
	private final int id;
	private boolean isOccupied;

	public SlotDto(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

}
