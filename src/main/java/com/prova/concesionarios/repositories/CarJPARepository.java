package com.prova.concesionarios.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.concesionarios.model.Car;

public interface CarJPARepository extends JpaRepository<Car, Long>{
	public List<Car> findAllByOrderBySellingDateDesc();
	public List<Car> findAllByOrderBySellingDateAsc();
	
	public List<Car> findAllByOrderByAdmissionDateAsc();
	public List<Car> findAllByOrderByAdmissionDateDesc();
}
