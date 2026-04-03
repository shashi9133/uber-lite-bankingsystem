package com.uber.driver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uber.driver.entity.Driver;
import com.uber.driver.entity.Status;

public interface DriverRepository extends JpaRepository<Driver, Long>{

	List<Driver> findByStatus(Status status);
}
