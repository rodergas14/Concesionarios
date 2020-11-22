package com.prova.concesionarios.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.concesionarios.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
	public List<Car> findAll(Sort sort);
}
