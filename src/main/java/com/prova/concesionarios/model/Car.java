package com.prova.concesionarios.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

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
	
	@Column(name = "COST", scale = 2)
	private BigDecimal cost;
	
	@Column(name = "SELLING_DATE")
	private LocalDateTime sellingDate;
	
	@Column(name = "ADMISSION_DATE")
	private LocalDateTime admissionDate;
	
	@Column(name = "IS_SOLD")
	private Boolean isSold;
	
	@Column(name = "REGISTRATION_NUMBER")
	private String registrationNumber;
	
	@Column(name = "SELLING_PRICE", scale = 2)
	private BigDecimal sellingPrice;
	
	//@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "DEALERSHIP_CAR_STREET", referencedColumnName = "STREET", insertable = false, updatable = false)
	@JoinColumn(name = "DEALERSHIP_CAR_CITY", referencedColumnName = "CITY",insertable = false, updatable = false)
	@JoinColumn(name = "DEALERSHIP_CAR_COUNTRY", referencedColumnName = "COUNTRY",insertable = false, updatable = false)
	@JoinColumn(name = "DEALERSHIP_CAR_STATE_OR_PROVINCE",referencedColumnName = "STATE_OR_PROVINCE", insertable = false, updatable = false)
	@JoinColumn(name = "DEALERSHIP_CAR_ZIP_CODE",referencedColumnName = "ZIP_CODE", insertable = false, updatable = false)
	private DealershipCar delearshipCar;


	
}
