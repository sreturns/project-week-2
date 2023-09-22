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

/**
 * Clase que utilizamo como controlador para la gestion de todas las funciones
 * del objeto tipo coche
 * 
 * @see com.projectweek2.model.Car
 * @see com.projectweek2.repositories.BbddInMemory
 */
@Controller
@RequestMapping("cars")
public class CarController {

    private static final String REDIRECT_MAIN_PAGE = "redirect:/";

    /**
     * Mostramos el formulario
     * 
     * @return addCar form
     */
    @GetMapping("/addCar")
    public String getCarForm() {
        return "forms/addCar.html";
    }

    /**
     * Guardamos un coche
     * 
     * @param car
     * @return main page
     */
    @PostMapping("/save")
    public String saveCarOnBbdd(@ModelAttribute Car car) {
        BbddInMemory.saveCar(car);
        return REDIRECT_MAIN_PAGE;
    }

    /**
     * 
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deleteCarFromBbdd(@PathVariable int id) {
        BbddInMemory.deleteCar(id);
        return REDIRECT_MAIN_PAGE;
    }

    /**
     * 
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/update/{id}")
    public String showUpdateCarForm(@PathVariable int id, Model model) {
        // Proporcionamos un id para poder encontrar el objeto a updatear en la BBDD
        Car car = BbddInMemory.findById(id);
        model.addAttribute("car", car);

        return "forms/updateCar.html";
    }

    /**
     * 
     * @param car
     * @return
     */
    @PostMapping("/update/save")
    public String updateCar(@ModelAttribute("car") Car car) {
        BbddInMemory.updateCar(car);
        return REDIRECT_MAIN_PAGE;
    }

}
