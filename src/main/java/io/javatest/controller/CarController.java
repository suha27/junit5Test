package io.javatest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.javatest.model.Car;
import io.javatest.service.CarService;

@RestController
public class CarController {

	@Autowired	
	private CarService carService;
	
	@GetMapping("car/{id}")
	public ResponseEntity<Car> getModelByCarId(@PathVariable int id) {
		Car car = carService.getModelByCarId(id);
		return ResponseEntity.ok(car);
	}
	
	@GetMapping("car/{name}")
	public ResponseEntity<Car> getModelByCarId(@PathVariable String name) {
		Car car = carService.getModelByCarName(name);
		return ResponseEntity.ok(car);
	}
}
