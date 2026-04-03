package com.uber.driver.dto;

import com.uber.driver.entity.Status;

import lombok.Data;

@Data
public class UpdateStatusRequest {

	private Status status;
}
