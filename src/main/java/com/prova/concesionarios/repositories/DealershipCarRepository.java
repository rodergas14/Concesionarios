package com.prova.concesionarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prova.concesionarios.model.Address;
import com.prova.concesionarios.model.DealershipCar;

@Repository
public interface DealershipCarRepository extends JpaRepository<DealershipCar, Address>{

	
}
