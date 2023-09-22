package com.projectweek2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectweek2.model.Car;
import com.projectweek2.repositories.BbddInMemory;

import org.springframework.ui.Model;

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
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showUpdateCarForm(@PathVariable int id, Model model) {
        // Aquí debes cargar los datos del coche con el ID proporcionado
        // desde la base de datos y agregarlos al modelo
        Car car = BbddInMemory.findById(id);
        model.addAttribute("car", car);

        return "forms/updateCar.html"; // Debes asegurarte de que coincida con el nombre de tu archivo HTML
    }

    @PostMapping("/update/save")
    public String updateCar(@ModelAttribute("car") Car car) {
        BbddInMemory.updateCar(car); // Suponiendo que tienes un método updateCar en tu servicio
        return "forms/updateCar.html"; // Redirecciona a la página de lista de automóviles
    }

}
