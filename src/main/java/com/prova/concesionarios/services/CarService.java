package com.prova.concesionarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prova.concesionarios.model.Car;
import com.prova.concesionarios.repositories.CarRepository;

@Service
public class CarService {

	private final CarRepository carRepostiory;

	public CarService(CarRepository carJPARepository) {
		this.carRepostiory = carJPARepository;
	}

	public Car insertCar(Car car) {
		return carRepostiory.save(car);
	}

	public List<Car> findAll(Sort sort) {
		return carRepostiory.findAll(sort);
	}

	public Optional<Car> findById(Long id) {
		return carRepostiory.findById(id);
	}

	public Optional<Car> updateCar(Car c, Long id) {
		return carRepostiory.findById(id).map(car -> {
			return carRepostiory.save(car);
		});

	}

	public Optional<Car> deleteCar(Long id) {
		return carRepostiory.findById(id).map(car -> {
			carRepostiory.deleteById(id);
			return car;
		});
	}

}
