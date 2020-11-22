package com.prova.concesionarios.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prova.concesionarios.model.Car;
import com.prova.concesionarios.repositories.CarRepository;
import com.prova.concesionarios.services.CarService;

@Service
public class CarServiceImpl implements CarService {
	
	private final CarRepository carRepostiory;
	
	public CarServiceImpl(CarRepository carJPARepository) {
		this.carRepostiory = carJPARepository;
	}
	
	@Override
	public Car insertCar(Car car) {
		return carRepostiory.save(car);
	}
	
	@Override
	public List<Car> findAll(Sort sort) {
		return carRepostiory.findAll(sort);
	}

	@Override
	public Optional<Car> findById(Long id) {
		return carRepostiory.findById(id);
	}

	@Override
	public Optional<Car> updateCar(Car c, Long id) {
		return carRepostiory.findById(id)
				.map(car -> {
					return carRepostiory.save(car);
				});
		
		
	}

	@Override
	public Optional<Car> deleteCar(Long id) {
		return carRepostiory.findById(id)
				.map(car -> {
					carRepostiory.deleteById(id);
					return car;
				});
	}



	
}
