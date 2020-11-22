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
		sort.stream()
		.filter(predicate)
		return carRepository.findAll(sort);
	}

	public Optional<Car> findById(Long id) {
		return carRepository.findById(id);
	}

	public Optional<Car> updateCar(Car c, Long id) {
		Optional<Car> selectedCarOptional = carRepository.findById(id);
		
		Car selectedCar = selectedCarOptional.get();
		if(isCarUpdatable(selectedCar)) {
			carRepository.save(selectedCar);
		}else {
			throw new RuntimeException("No se puede modificar un coche ya vendido");
		}
		
		return selectedCarOptional;
				
	}

	public Optional<Car> deleteCar(Long id) {
		
		Optional<Car> selectedCarOptional = carRepository.findById(id);
		
		Car selectedCar = selectedCarOptional.get();
		if(isCarDeletable(selectedCar)) {
			carRepository.deleteById(id);
		}else {
			throw new RuntimeException("No se puede eliminar un coche ya vendido");
		}
		
		return selectedCarOptional;
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
