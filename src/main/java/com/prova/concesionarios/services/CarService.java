package com.prova.concesionarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prova.concesionarios.model.Car;
import com.prova.concesionarios.repositories.CarRepository;

@Service
public class CarService {

	private final CarRepository carRepository;

	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public Car insertCar(Car car) {
		return carRepository.save(car);
	}

	public List<Car> findAll(Sort sort) {
		return carRepository.findAll(sort);
	}

	public Optional<Car> findById(Long id) {
		return carRepository.findById(id);
	}

	public Optional<Car> updateCar(Car c, Long id) {
		return carRepository.findById(id)
				.map(carRepository::save);
	}

	public Optional<Car> deleteCar(Long id) {
		return carRepository.findById(id).map(car -> {
			carRepository.deleteById(id);
			return car;
		});
	}

}
