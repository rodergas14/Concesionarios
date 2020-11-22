package com.prova.concesionarios.api;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prova.concesionarios.model.Car;
import com.prova.concesionarios.services.CarService;


@RestController
@RequestMapping("/cars")
public class CarAPI {
	
	private final CarService carService;
	
	public CarAPI(CarService carService) {
		this.carService = carService;
	}
	
	@PostMapping
	public ResponseEntity<Void> insertCar(@RequestBody Car car) {
    	Car insertedCar = carService.insertCar(car);

    	URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(insertedCar.getId())
                .toUri();

    	return ResponseEntity.created(location).build();
	}
	
    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") Long id) {
        return carService.findById(id)
     		   .map(ResponseEntity::ok)
     		   .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public List<Car> getAll(Sort sort) {
        return carService.findAll(sort);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCar(@RequestBody Car car,
    		@PathVariable("id") Long id) {
    	return carService.updateCar(car, id)
    			.map(carInstance -> ResponseEntity.noContent().<Void>build())
    			.orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") Long id) {
    	return carService.deleteCar(id)
		    	.map(car -> ResponseEntity.ok().<Void>build())
    			.orElseGet(() -> ResponseEntity.notFound().build());
    }

}
