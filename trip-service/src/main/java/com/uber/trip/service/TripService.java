package com.uber.trip.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uber.trip.client.DriverClient;
import com.uber.trip.dto.DriverResponse;
import com.uber.trip.dto.TripRequest;
import com.uber.trip.entity.Trip;
import com.uber.trip.entity.TripStatus;
import com.uber.trip.repository.TripRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final DriverClient driverClient;

    
    private final RestTemplate restTemplate;

    public Trip requestTrip(TripRequest request) {

        List<DriverResponse> drivers = driverClient.getAvailableDrivers();

        if (drivers.isEmpty()) {
            throw new RuntimeException("No drivers available");
        }

        DriverResponse driver = drivers.get(0);

        Trip trip = Trip.builder()
                .riderId(request.getRiderId())
                .driverId(driver.getId())
                .pickupLat(request.getPickupLat())
                .pickupLon(request.getPickupLon())
                .dropLat(request.getDropLat())
                .dropLon(request.getDropLon())
                .status(TripStatus.REQUESTED)
                .build();

        return tripRepository.save(trip);
    }

    public Trip acceptTrip(Long tripId) {

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        trip.setStatus(TripStatus.ACCEPTED);
        return tripRepository.save(trip);
    }

    public Trip startTrip(Long tripId) {

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        trip.setStatus(TripStatus.IN_PROGRESS);
        return tripRepository.save(trip);
    }

    public Trip completeTrip(Long tripId) {

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        trip.setStatus(TripStatus.COMPLETED);

        Trip savedTrip = tripRepository.save(trip);

        
        try {
            restTemplate.postForObject(
                    "http://notification-service:8084/api/notify",
                    savedTrip,
                    String.class
            );
        } catch (Exception e) {
            System.out.println("Notification Service Error: " + e.getMessage());
        }

        return savedTrip;
    }
}
