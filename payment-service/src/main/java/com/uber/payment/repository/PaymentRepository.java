package com.uber.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uber.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
