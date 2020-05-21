package com.interview.parkinglot.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.interview.parkinglot.dto.VehicleRequestDto;

@Component
public class ParkedVechicleService {

	private List<VehicleRequestDto> vechicleRequestDtoList;

	@PostConstruct
	public void init() {
		vechicleRequestDtoList = new ArrayList<>();
	}

	public void storeIncomingVehicle(VehicleRequestDto vechicleRequestDto) {
		vechicleRequestDtoList.add(vechicleRequestDto);
	}

	public List<VehicleRequestDto> getVechicleRequestDtoList() {
		return vechicleRequestDtoList;
	}

}
