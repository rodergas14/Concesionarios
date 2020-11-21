package com.prova.concesionarios.model;

import java.util.Set;

public class DealershipCar {
	private String name;
	private Address address;
	private Set<Car> cars;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Car> getCars() {
		return cars;
	}
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	
	
}
