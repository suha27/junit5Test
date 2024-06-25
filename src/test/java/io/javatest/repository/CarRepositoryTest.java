package io.javatest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import io.javatest.model.Car;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CarRepositoryTest {
	
	private CarRepository carRepository;

	@Autowired
	public CarRepositoryTest(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@Test
	public void savealltest() {
		Car car = Car.builder().name("Honda").model(1945).build();
		
		Car savedCar = carRepository.save(car);
		
		assertThat(savedCar).isNotNull();
		assertThat(savedCar.getId()).isGreaterThan(0);
	}
	
}
