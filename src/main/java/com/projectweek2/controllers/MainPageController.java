package com.projectweek2.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectweek2.model.Car;
import com.projectweek2.repositories.BbddInMemory;

@Controller
@RequestMapping("/")
public class MainPageController {

	@GetMapping
	public String mainPageView(Model model) {
		List<Car> listOfCars = BbddInMemory.getListOfVehicles();

		model.addAttribute("listOfCars", listOfCars);
		return "index.html";
	}

}
