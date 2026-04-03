package com.uber.trip.dto;

import lombok.Data;

@Data
public class DriverResponse {

	private Long id;
    private Long userId;
    private String status;
    private Double latitude;
    private Double longitude;
}
