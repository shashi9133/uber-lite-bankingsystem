package com.uber.trip.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uber.trip.dto.TripRequest;
import com.uber.trip.entity.Trip;
import com.uber.trip.service.TripService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TaskController {

	private final TripService tripService;
	
	@PostMapping("/request")
	public Trip requestTrip(@RequestBody TripRequest request) {
		return tripService.requestTrip(request);
	}
	
	@PutMapping("/{id}/accept")
	public Trip acceptTrip(@PathVariable Long id) {
		return tripService.acceptTrip(id);
	}
	
	@PutMapping("/{id}/start")
	public Trip startTrip(@PathVariable Long id) {
		return tripService.startTrip(id);
	}
	
	@PutMapping("/{id}/complete")
	public Trip completeTrip(@PathVariable Long id) {
		return tripService.completeTrip(id);
	}
}
