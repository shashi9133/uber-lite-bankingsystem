package com.uber.payment.service;

import org.springframework.stereotype.Service;

import com.uber.payment.entity.Payment;
import com.uber.payment.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentRepository paymentRepository;
	
	public Payment processPayment(Long tripId, Long driverId, Long riderId) {
		
		double amount = 100 + Math.random() * 200;
		
		Payment payment = Payment.builder()
				.tripId(tripId)
				.driverId(driverId)
				.riderId(riderId)
				.amount(amount)
				.status("SUCCESS")
				.build();
		
		return paymentRepository.save(payment);
	}
}
