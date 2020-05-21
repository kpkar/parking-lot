package com.interview.parkinglot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.interview.parkinglot.dto.ParkedVehicle;

@Component
public class VehicleService {

	public List<ParkedVehicle> getParkedVechicles() {
		List<ParkedVehicle> parkedVehicles = new ArrayList<>();
		return parkedVehicles;
	}
}
