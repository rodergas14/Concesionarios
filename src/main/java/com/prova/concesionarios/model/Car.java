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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CAR")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity{
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "BRAND")
	private String brand;
	
	@Column(name = "COST")
	private Double cost;
	
	@Column(name = "SELLING_DATE")
	private LocalDateTime sellingDate;
	
	@Column(name = "ADMISSION_DATE")
	private LocalDateTime admissionDate;
	
	@Column(name = "IS_SOLD")
	private Boolean isSold;
	
	@Column(name = "REGISTRATION_NUMBER")
	private String registrationNumber;
	
	@Column(name = "SELLING_PRICE")
	private Double sellingPrice;
	
	@ManyToOne
	@JoinColumn(name = "DEALERSHIP_CAR_STREET", referencedColumnName = "STREET", insertable = false, updatable = false)
	@JoinColumn(name = "DEALERSHIP_CAR_CITY", referencedColumnName = "CITY",insertable = false, updatable = false)
	@JoinColumn(name = "DEALERSHIP_CAR_COUNTRY", referencedColumnName = "COUNTRY",insertable = false, updatable = false)
	@JoinColumn(name = "DEALERSHIP_CAR_STATE_OR_PROVINCE",referencedColumnName = "STATE_OR_PROVINCE", insertable = false, updatable = false)
	@JoinColumn(name = "DEALERSHIP_CAR_ZIP_CODE",referencedColumnName = "ZIP_CODE", insertable = false, updatable = false)
	private DealershipCar delearshipCar;

	
}
