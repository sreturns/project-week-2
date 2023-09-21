package com.projectweek2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectweek2.model.Vehicle;
import com.projectweek2.repositories.BbddInMemory;

@Controller
@RequestMapping("/")
public class MainPageController {


    @GetMapping
    public String ModelAndView(Model model) {
        List<Vehicle> listOfVehicles = BbddInMemory.getListOfVehicles();
        model.addAttribute("test", "this is a test");
        model.addAttribute("listOfVehicles", listOfVehicles);
        return "index.html";
    }

}
