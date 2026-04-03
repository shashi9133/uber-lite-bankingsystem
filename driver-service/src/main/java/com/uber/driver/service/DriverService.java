package com.uber.driver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uber.driver.entity.Driver;
import com.uber.driver.entity.Status;
import com.uber.driver.repository.DriverRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DriverService {

	private final DriverRepository driverRepository;
	
	public Driver register(Driver driver) {
		driver.setStatus(Status.OFFLINE);
		return driverRepository.save(driver);
	}
	
	public Driver updateStatus(Long driverId, Status status) {
		Driver driver = driverRepository.findById(driverId)
				.orElseThrow(() -> new RuntimeException("Driver not found"));
		
		if(status == null) {
			throw new RuntimeException("Status cannot be null");
		}
		
		driver.setStatus(status);
		return driverRepository.save(driver);
	}
	
	public Driver updateLocation(Long driverId, Double lat, Double lon) {
		Driver driver = driverRepository.findById(driverId)
				.orElseThrow(() -> new RuntimeException("Driver not found"));
		
		driver.setLatitude(lat);
		driver.setLongitude(lon);
		
		return driverRepository.save(driver);
	}
	
	public List<Driver> getAvailableDrivers() {
		return driverRepository.findByStatus(Status.AVAILABLE);
	}
}
