package com.prova.concesionarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import com.prova.concesionarios.model.Car;

public interface CarService {
	public List<Car> findAll(Sort sort);
	public Optional<Car> findById(Long id);
	public Optional<Car> updateCar(Car car, Long id);
	public void deleteCar(Long id);
	public Car insertCar(Car car);
}
