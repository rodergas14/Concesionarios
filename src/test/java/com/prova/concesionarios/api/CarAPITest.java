package com.prova.concesionarios.api;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.prova.concesionarios.model.Car;
import com.prova.concesionarios.services.CarService;

@WebMvcTest(CarAPI.class)
public class CarAPITest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CarService service;

	@Test
	public void findAll() throws Exception {
		List<Car> cars = new ArrayList<>();
		Car c = new Car().builder()
				.name("Test car").build();
		
		Car c1 = new Car().builder()
				.name("Test car1").build();
		cars.add(c); cars.add(c1);

		when(service.findAll(Sort.by("sellingDate").descending())).thenReturn(cars);
		this.mockMvc.perform(get("/cars?sort=sellingDate,desc")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Test car1")));
	}
	
	@Test
	public void findById() throws Exception {

		Car c = new Car().builder()
				.name("Test car").build();
	

		when(service.findById(1L)).thenReturn(Optional.of(c));
		this.mockMvc.perform(get("/cars/1")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Test car")));
	}
	
	@Test
	public void updateTest() throws Exception {

		Car c = new Car().builder()
				.name("Test car").build();
	

		when(service.updateCar(c, 1L)).thenReturn(Optional.of(c));
		this.mockMvc.perform(put("/cars/1")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Test car")));
	}
	
	@Test
	public void deleteTest() throws Exception {

		Car c = new Car().builder()
				.name("Test car").build();
	

		when(service.deleteCar(1L)).thenReturn(Optional.of(c));
		this.mockMvc.perform(delete("/cars/1")).andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	public void create() throws Exception {

		Car c = new Car().builder()
				.name("Test car").build();
	

		when(service.insertCar(c)).thenReturn(c);
		this.mockMvc.perform(post("/cars")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Test car")));
	}
}


