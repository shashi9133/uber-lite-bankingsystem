package com.uber.payment.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.uber.payment.event.TripEvent;
import com.uber.payment.service.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentConsumer {

	private final PaymentService paymentService;
	
	@KafkaListener(topics = "trip-events", groupId = "payment-group")
	public void consumer(TripEvent event) {
		
		if("COMPLETED".equals(event.getStatus())) {
			
			paymentService.processPayment(event.getTripId(), event.getDriverId(), event.getRiderId());
			
			System.out.println("Payment processed for trip: " + event.getTripId());
		}
	}
}
