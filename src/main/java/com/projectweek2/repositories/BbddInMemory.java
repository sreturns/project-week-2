package com.projectweek2.repositories;

import java.util.ArrayList;
import java.util.List;

import com.projectweek2.model.Car;

public class BbddInMemory {

    private BbddInMemory() {
    }

    private static List<Car> listOfVehicles = getListOfVehiclesData();

    /**
     * Generamos una lista con vehiculos, de tipo Car, Motorcycle y Bicycle
     */
    public static List<Car> getListOfVehiclesData() {
        ArrayList<Car> list = new ArrayList<>();

        Car car1 = new Car("Tesla", "S", 80_000, 500, "Electric");
        Car car2 = new Car("Tesla", "X", 70_000, 5000, "Electric");
        Car car3 = new Car("BMW", "M5", 120_000, 700, "Fuel");
        Car car4 = new Car("Audi", "RS6", 200_000, 750, "Fuel");
        Car car5 = new Car("Mercedes", "EQ", 90_000, 600, "Electric");
        Car car6 = new Car("Cupra", "Rebel", 40_000, 250, "Fuel");
        Car car7 = new Car("Ferrari", "Roma", 300_000, 800, "Hybrid");

        list.add( car1);
        list.add( car2);
        list.add( car3);
        list.add( car4);
        list.add( car5);
        list.add( car6);
        list.add( car7);

        return list;
    }

    public static List<Car> getListOfVehicles() {
        return listOfVehicles;
    }

}
