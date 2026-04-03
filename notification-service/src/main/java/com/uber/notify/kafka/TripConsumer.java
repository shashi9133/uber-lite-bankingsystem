package com.uber.notify.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.uber.notify.event.TripEvent;

@Service
public class TripConsumer {

	@KafkaListener(topics = "trip-events", groupId = "notification-group")
	public void consume(TripEvent event) {
		
		System.out.println("📩 Notification Received:");
        System.out.println("Trip ID: " + event.getTripId());
        System.out.println("Driver ID: " + event.getDriverId());
        System.out.println("Rider ID: " + event.getRiderId());
        System.out.println("Status: " + event.getStatus());
	}
}
