package com.prova.concesionarios.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.prova.concesionarios.model.Car.CarBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable{
	@Column(name = "street")
	private String street;
	@Column(name = "city")
	private String city;
	@Column(name = "country")
	private String country;
	@Column(name = "stateOrProvince")
	private String stateOrProvince;
	@Column(name = "zipCode")
	private String zipCode;
	
	
	
}
