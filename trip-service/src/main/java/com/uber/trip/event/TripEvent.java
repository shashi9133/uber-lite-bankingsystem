package com.uber.trip.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripEvent {

	private Long tripId;
	private Long driverId;
	private Long riderId;
	private String status;
}
