package io.javatest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javatest.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{
	Optional<Car> findByName(String name);
}
