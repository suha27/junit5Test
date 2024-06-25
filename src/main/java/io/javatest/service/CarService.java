package io.javatest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javatest.model.Car;
import io.javatest.repository.CarRepository;

@Service
public class CarService {
	private CarRepository carRepository;
	
	@Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
	
	public Car getModelByCarName(String name) {
		Car car = carRepository.findByName(name).get();
		return car;
	}
	
	public Car getModelByCarId(Integer id) {
		Car car = carRepository.findById(id).get();
		return car;
	}
}
