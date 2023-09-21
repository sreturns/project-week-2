package com.projectweek2.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectweek2.model.Car;
import com.projectweek2.repositories.BbddInMemory;

@Controller
@RequestMapping("cars")
public class CarController {

    @GetMapping("/addCar")
    public String getCarForm() {
        return "forms/addCar.html";
    }

    @PostMapping("/save")
    public String saveCarOnBbdd(@ModelAttribute Car car) {
        BbddInMemory.saveCar(car);
        return "redirect:/cars/addCar";
    }

    @GetMapping("/delete/{id}")
    public String deleteCarFromBbdd(@PathVariable int id) {
        BbddInMemory.deleteCar(id);
        return "redirect:/cars/addCar";
    }

}
