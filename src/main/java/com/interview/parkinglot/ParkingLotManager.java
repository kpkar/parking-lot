package com.interview.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interview.parkinglot.dto.SlotDto;
import com.interview.parkinglot.dto.VehicleRequestDto;
import com.interview.parkinglot.services.CostService;
import com.interview.parkinglot.services.ParkedVechicleService;
import com.interview.parkinglot.services.SlotService;
import com.interview.parkinglot.services.VehicleService;

@Component
public class ParkingLotManager {

	@Autowired
	private CostService costService;
	@Autowired
	private VehicleService vechicleService;
	@Autowired
	private ParkedVechicleService parkedVechicleService;

	@Autowired
	private SlotService slotService;
	private Map<SlotDto, VehicleRequestDto> slotMapping;

	@PostConstruct
	public void init() {
		slotMapping = new HashMap<>();
	}

	public String storeIncomingVehicle(VehicleRequestDto vechicleRequestDto) {
		if (manageSlotMapping(vechicleRequestDto)) {
			parkedVechicleService.storeIncomingVehicle(vechicleRequestDto);
			return "Parked";
		} else {
			return "No slot for parking";
		}
	}

	public Long getCharges(Integer vehicleNumber) {
		return costService.calculateCharges(vehicleNumber);
	}

	public List<VehicleRequestDto> getParkedVehicles() {
		return parkedVechicleService.getVechicleRequestDtoList();
	}

	public boolean isSlotAvailable() {
		return slotService.isSlotAvaiable();
	}

	private boolean manageSlotMapping(VehicleRequestDto vechicleRequestDto) {
		if (isSlotAvailable()) {
			SlotDto freeSlot = slotService.getFreeSlot();
			freeSlot.setOccupied(true);
			slotMapping.put(freeSlot, vechicleRequestDto);
			return true;
		} else {
			return false;
		}
	}

}
