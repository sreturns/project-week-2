package com.projectweek2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectweek2.dto.CarListDTO;
import com.projectweek2.model.Car;
import com.projectweek2.repositories.BbddInMemory;

@RestController
@RequestMapping("/api/cars")
public class ApiCarController {

    @GetMapping
    public CarListDTO getAllCars() {
        List<Car> cars = BbddInMemory.getListOfVehicles();
        return new CarListDTO(cars);
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        return BbddInMemory.findById(id);
    }

    @PostMapping("/add")
    public void addCar(@RequestBody Car car) {
        BbddInMemory.saveCar(car);
    }

    @PostMapping("/update/{id}")
    public void updateCar(@RequestBody Car car, @PathVariable int id) {
        car.setId(id);
        BbddInMemory.updateCar(car);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable int id) {
        BbddInMemory.deleteCar(id);
    }

    @GetMapping("/size")
    public int getListOfCarsSize() {
        return BbddInMemory.getListSize();
    }

}
