package com.uber.driver.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uber.driver.dto.UpdateStatusRequest;
import com.uber.driver.entity.Driver;
import com.uber.driver.entity.Status;
import com.uber.driver.service.DriverService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DriverController {

	private final DriverService driverService;
	
	@PostMapping("/register")
    public Driver register(@RequestBody Driver driver) {
        return driverService.register(driver);
    }

    @PutMapping("/{id}/status")
    public Driver updateStatus(@PathVariable Long id, @RequestBody UpdateStatusRequest request) {
        return driverService.updateStatus(id, request.getStatus());
    }

    @PutMapping("/{id}/location")
    public Driver updateLocation(
            @PathVariable Long id,
            @RequestParam Double lat,
            @RequestParam Double lon) {

        return driverService.updateLocation(id, lat, lon);
    }

    @GetMapping("/available")
    public List<Driver> getAvailableDrivers() {
        return driverService.getAvailableDrivers();
    }
}
