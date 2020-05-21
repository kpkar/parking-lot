package com.interview.parkinglot;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.parkinglot.dto.VehicleRequestDto;

@RestController
public class ParkingLotAPI {

	// storeIncomingVehicle - POST
	// getCharges - GET
	// getListOfVechicles - GET
	// isSlotAvaiable - GET

	@Autowired
	private ParkingLotManager parkingLotManager;

	@PostMapping(value = "/api/v1/parking-lot/vehicle")
	public void storeIncomingVehicle(HttpServletRequest request, @RequestBody VehicleRequestDto vehicleRequestDto) {
		parkingLotManager.storeIncomingVehicle(vehicleRequestDto);
	}

	@GetMapping(value = "/api/v1/parking-lot/charges/{vehicleNumber}")
	public Long getCharges(HttpServletRequest request, @PathVariable Integer vehicleNumber) {
		return parkingLotManager.getCharges(vehicleNumber);
	}

	@GetMapping(value = "/api/v1/parking-lot/vehicles")
	public List<VehicleRequestDto> getParkedVehicles(HttpServletRequest request) {
		return parkingLotManager.getParkedVehicles();
	}

	@GetMapping(value = "/api/v1/parking-lot/slot")
	public boolean isSlotAvailable(HttpServletRequest request) {
		return parkingLotManager.isSlotAvailable();
	}
}
