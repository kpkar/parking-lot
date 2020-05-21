package com.interview.parkinglot.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interview.parkinglot.dto.VehicleRequestDto;

@Component
public class CostService {

	private Map<String, Long> vehicheTypeCost = new HashMap<>();
	@Autowired
	private ParkedVechicleService parkedVechicleService;

	@PostConstruct
	public void init() {

		vehicheTypeCost.put("Bike", 20L);
		vehicheTypeCost.put("Car", 30L);
	}

	public Long calculateCharges(Integer vehicleNumber) {

		// Calulate based on number of hrs.
		List<VehicleRequestDto> parkedVehicles = parkedVechicleService.getVechicleRequestDtoList();

		Optional<VehicleRequestDto> findVehicle = parkedVehicles.stream()
				.filter(vehicle -> vehicle.getVechicleNumber().equals(vehicleNumber)).findFirst();
		if (!findVehicle.isPresent()) {
			return -1L;
		}
		VehicleRequestDto vehicleDto = findVehicle.get();

		Date startTime = vehicleDto.getIncomingTime();
		Date endTime = vehicleDto.getOutgoingTime();
		Long totalTime = endTime.getTime() - startTime.getTime();
		Long totalHour = totalTime / 1000 / 3600;
		totalHour = (long) Math.ceil(totalHour);
		return vehicheTypeCost.get(vehicleDto.getVechicleType()) * totalHour;

	}

}
