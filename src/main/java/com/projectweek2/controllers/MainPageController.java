package com.projectweek2.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectweek2.model.Car;
import com.projectweek2.repositories.BbddInMemory;

/**
 * Controlador Main que muestra la lista de coche en la vista principal
 * 
 * @see com.projectweek2.controllers.CarController
 * @see com.projectweek2.repositories.BbddInMemory
 */
@Controller
@RequestMapping("/")
public class MainPageController {

private static List<Car> listOfCars = BbddInMemory.getListOfVehicles();

	@GetMapping
	public String mainPageView(Model model) {
		model.addAttribute("listOfCars", listOfCars);
		return "index.html";
	}

}
