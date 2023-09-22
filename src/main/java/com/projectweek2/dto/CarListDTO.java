package com.projectweek2.dto;

import java.util.List;

import com.projectweek2.model.Car;

/**
 * Creamos la clase CarListDTO para mapear nuestra respuesta de la api, y que se
 * un objeto que contenga un array y no un array directo, para evitar exploits
 * como indicado en el curso
 * 
 * @see com.projectweek2.controllers.ApiCarController
 */
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
