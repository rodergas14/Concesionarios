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

	public Optional<Car> updateCar(Car car, Long id) {
		
		return carRepository.findById(id)
		.filter(carInstance -> isCarUpdatable(carInstance))
		.map(carInstance -> Optional.of(carRepository.save(car)))
		.orElseThrow(() -> new RuntimeException("No se puede modificar el coche"));
				
	}

	public Optional<Car> deleteCar(Long id) {
		
		return carRepository.findById(id)
		.filter(carInstance -> isCarDeletable(carInstance))
		.map(carInstance -> {
			carRepository.delete(carInstance);
			return Optional.of(carInstance);
		})
		.orElseThrow(() -> new RuntimeException("No se puede eliminar el coche"));
	}
	
	private boolean isCarUpdatable(Car car) {
		boolean isUpdatable = true;
		if(car.getIsSold()) isUpdatable = false;
		
		return isUpdatable;
	}
	
	private boolean isCarDeletable(Car car) {
		boolean isDeletable = true;
		if(car.getIsSold()) isDeletable = false;
		
		return isDeletable;
	}
}
