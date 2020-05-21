package com.interview.parkinglot.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.interview.parkinglot.dto.SlotDto;

@Repository
public class SlotRepo {

	private static final int MAX_SLOTS = 100;

	private List<SlotDto> slots = new ArrayList<SlotDto>();

	@PostConstruct
	private void init() {
		for (int i = 0; i < MAX_SLOTS; i++) {
			slots.add(new SlotDto(i));
		}
	}

	public List<SlotDto> getSlots() {
		return slots;
	}
}
