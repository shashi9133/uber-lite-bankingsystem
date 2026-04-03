package com.uber.trip.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.uber.trip.event.TripEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TripProducer {

	private final KafkaTemplate<String, TripEvent> kafkaTemplate;
	
	public void sendTripEvent(TripEvent event) {
		kafkaTemplate.send("trip-events", event);
	}
}
