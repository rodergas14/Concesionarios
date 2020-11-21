package com.prova.concesionarios.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
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
	
	@Column(name = "dealershipCar")
	@JoinColumn(name = "dealearship_car_id")
	private DealershipCar delearshipCar;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public LocalDateTime getSellingDate() {
		return sellingDate;
	}
	public void setSellingDate(LocalDateTime sellingDate) {
		this.sellingDate = sellingDate;
	}
	public LocalDateTime getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(LocalDateTime admissionDate) {
		this.admissionDate = admissionDate;
	}
	public Boolean getIsSold() {
		return isSold;
	}
	public void setIsSold(Boolean isSold) {
		this.isSold = isSold;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	
}
