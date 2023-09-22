package com.projectweek2.controllers;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

/**
 * Clase Controlador que usamos para el funcionamiento de nuestra api
 * 
 * @see com.projectweek2.repositories.BbddInMemory
 */
@RestController
@RequestMapping("/api/cars")
public class ApiCarController {

    /**
     * Mostramos todos los coches en un objeto cocheDTO que contiene un array de
     * coches, de esta manera evitamos posibles exploits
     * 
     * @return CarListDTO
     */
    @GetMapping
    public CarListDTO getAllCars() {
        List<Car> cars = BbddInMemory.getListOfVehicles();
        return new CarListDTO(cars);
    }

    /**
     * Mostramos un objeto a traves de su id
     */
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        return BbddInMemory.findById(id);
    }

    /**
     * Guardamos un coche pasandole un objeto JSON de tipo coche a traves del metodo
     * Post
     */
    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {

        BbddInMemory.saveCar(car);

        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }

    /**
     * Hacemos un update del coche con un JSON del tipo coche, el update se hace
     * teniendo en cuenta el id
     * 
     * @param id
     */
    @PostMapping("/update/{id}")
    public void updateCar(@RequestBody Car car, @PathVariable int id) {
        car.setId(id);
        BbddInMemory.updateCar(car);
    }

    /**
     * Hacemos un delete de un objeto tipo coche a traves del id
     * 
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable int id) {
        BbddInMemory.deleteCar(id);
    }

    /**
     * Mostramos el total de coches
     * 
     * @return size
     */
    @GetMapping("/size")
    public int getListOfCarsSize() {
        return BbddInMemory.getListSize();
    }

}
