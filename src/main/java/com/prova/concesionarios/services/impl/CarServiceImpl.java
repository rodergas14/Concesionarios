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
	
	private final CarRepository carJPARepository;
	
	public CarServiceImpl(CarRepository carJPARepository) {
		this.carJPARepository = carJPARepository;
	}
	
	@Override
	public Car insertCar(Car car) {
		return carJPARepository.save(car);
	}
	
	@Override
	public List<Car> findAll(Sort sort) {
		return carJPARepository.findAll(sort);
	}

	@Override
	public Optional<Car> findById(Long id) {
		return carJPARepository.findById(id);
	}

	@Override
	public Optional<Car> updateCar(Car c, Long id) {
		return carJPARepository.findById(id)
				.map(car -> {
					return carJPARepository.save(car);
				});
		
		
	}

	@Override
	public void deleteCar(Long id) {
		carJPARepository.deleteById(id);
	}



	
}
