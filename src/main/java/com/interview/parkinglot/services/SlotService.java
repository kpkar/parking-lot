package com.interview.parkinglot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.parkinglot.dto.SlotDto;

@Service
public class SlotService {

	@Autowired
	private SlotRepo slotRepo;

	public boolean isSlotAvaiable() {
		return getFreeSlot() != null;
	}

	public SlotDto getFreeSlot() {
		List<SlotDto> slots = slotRepo.getSlots();
		Optional<SlotDto> findFirst = slots.stream().filter(slot -> !slot.isOccupied()).findFirst();
		return findFirst.isPresent() ? findFirst.get() : null;
	}

}
