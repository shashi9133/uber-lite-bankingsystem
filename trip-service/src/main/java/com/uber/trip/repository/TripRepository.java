package com.uber.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uber.trip.entity.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
