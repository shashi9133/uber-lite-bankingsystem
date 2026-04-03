package com.uber.trip.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.uber.trip.dto.DriverResponse;

@FeignClient(name = "driver-service", url = "http://localhost:8082")
public interface DriverClient {

	@GetMapping("api/drivers/available")
	List<DriverResponse> getAvailableDrivers();
}
