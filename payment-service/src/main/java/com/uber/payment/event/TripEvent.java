package com.uber.payment.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripEvent {

	private Long tripId;
	private Long driverId;
	private Long riderId;
	private String status;
}
