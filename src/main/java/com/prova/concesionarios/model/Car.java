package com.prova.concesionarios.model;

import java.time.LocalDateTime;

public class Car extends BaseEntity{
	
	private String name;
	private String brand;
	private Double cost;
	private LocalDateTime sellingDate;
	private LocalDateTime admissionDate;
	private Boolean isSold;
	private String registrationNumber;
	private Double sellingPrice;
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
