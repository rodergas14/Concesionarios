package com.prova.concesionarios.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "Dealerships")
public class DealershipCar {
	
	@Column(name = "name")
	private String name;
	
	@EmbeddedId
	private Address address;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			mappedBy = "delearshipCar"
			)
	private Set<Car> cars;
	
	@Formula("(select (sum(c.sellingPrice) - sum(c.cost)) as benefits from Cars c "
			+ "where c.dealershipCarStreet = address.street "
			+ "AND c.dealershipCarCity = address.city "
			+ "AND c.dealershipCarCountry = address.country "
			+ "AND c.dealershipStateOrProvince = address.stateOrProvince "
			+ "AND c.dealershipZipCode = address.zipCode"
			+ ")")
	private Double benefits;
	
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
