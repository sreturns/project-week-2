package com.projectweek2.dto;

import java.util.List;

import com.projectweek2.model.Car;

public class CarListDTO {

	private List<Car> cars;

	public CarListDTO(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}
