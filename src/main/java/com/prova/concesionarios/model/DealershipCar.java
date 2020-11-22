package com.prova.concesionarios.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="DEALERSHIP_CAR")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DealershipCar {
	
	@Column(name = "NAME")
	private String name;
	
	@EmbeddedId
	private Address address;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			mappedBy = "delearshipCar"
			)
	private Set<Car> cars;
	
	
	@Formula("(select COALESCE(sum(c.SELLING_PRICE),0) - COALESCE(sum(c.COST),0)  from CAR c "
			+ "where c.DEALERSHIP_CAR_STREET = STREET "
			+ "AND c.DEALERSHIP_CAR_CITY = CITY "
			+ "AND c.DEALERSHIP_CAR_COUNTRY = COUNTRY "
			+ "AND c.DEALERSHIP_CAR_STATE_OR_PROVINCE = STATE_OR_PROVINCE "
			+ "AND c.DEALERSHIP_CAR_ZIP_CODE = ZIP_CODE"
			+ ")")

	private Double benefits;

	
}
