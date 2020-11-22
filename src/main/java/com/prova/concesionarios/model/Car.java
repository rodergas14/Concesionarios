package com.prova.concesionarios.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CAR")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "cost")
	private Double cost;
	
	@Column(name = "sellingDate")
	private LocalDateTime sellingDate;
	
	@Column(name = "admissionDate")
	private LocalDateTime admissionDate;
	
	@Column(name = "isSold")
	private Boolean isSold;
	
	@Column(name = "registrationNumber")
	private String registrationNumber;
	
	@Column(name = "sellingPrice")
	private Double sellingPrice;
	
	@ManyToOne
	@JoinColumn(name = "dealershipCarStreet", referencedColumnName = "street", insertable = false, updatable = false)
	@JoinColumn(name = "dealershipCarCity", referencedColumnName = "city",insertable = false, updatable = false)
	@JoinColumn(name = "dealershipCarCountry", referencedColumnName = "country",insertable = false, updatable = false)
	@JoinColumn(name = "dealershipCarStateOrProvince",referencedColumnName = "stateOrProvince", insertable = false, updatable = false)
	@JoinColumn(name = "dealershipCarZipCode",referencedColumnName = "zipcode", insertable = false, updatable = false)
	private DealershipCar delearshipCar;

	
}
