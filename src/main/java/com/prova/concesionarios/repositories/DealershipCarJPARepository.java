package com.prova.concesionarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.concesionarios.model.Address;
import com.prova.concesionarios.model.DealershipCar;


public interface DealershipCarJPARepository extends JpaRepository<DealershipCar, Address>{
	
	
}
