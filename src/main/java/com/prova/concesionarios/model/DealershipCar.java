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
@Table(name="DEALERSHIP_CAR")
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
	
	
	/*
	@Formula("(select sum(c.sellingPrice)  as benefits from Cars c "
			+ "where c.DEALERSHIP_CAR_STREET = address.STREET "
			+ "AND c.DEALERSHIP_CAR_CITY = address.CITY "
			+ "AND c.DEALERSHIP_CAR_COUNTRY = address.COUNTRY "
			+ "AND c.DEALERSHIP_CAR_STATE_OR_PROVIN = address.STATE_OR_PROVINCE "
			+ "AND c.DEALERSHIP_CAR_ZIP_CODE = address.ZIP_CODE"
			+ ")")
			*/
	
	@Formula("(select sum(c.SELLING_PRICE) - sum(c.COST)  from CAR c "
			+ "where c.DEALERSHIP_CAR_STREET = STREET "
			+ "AND c.DEALERSHIP_CAR_CITY = CITY "
			+ "AND c.DEALERSHIP_CAR_COUNTRY = COUNTRY "
			+ "AND c.DEALERSHIP_CAR_STATE_OR_PROVINCE = STATE_OR_PROVINCE "
			+ "AND c.DEALERSHIP_CAR_ZIP_CODE = ZIP_CODE"
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

	public Double getBenefits() {
		return benefits;
	}

	public void setBenefits(Double benefits) {
		this.benefits = benefits;
	}
	

	
}
