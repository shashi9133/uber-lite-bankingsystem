package com.uber.trip.dto;

import lombok.Data;

@Data
public class TripRequest {

	private Long riderId;
	
	private Double pickupLat;
	private Double pickupLon;
	
	private Double dropLat;
	private Double dropLon;
}
