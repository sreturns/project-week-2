package com.projectweek2.repositories;

import java.util.ArrayList;
import java.util.List;

import com.projectweek2.model.Bicycle;
import com.projectweek2.model.Car;
import com.projectweek2.model.Motor;
import com.projectweek2.model.Motorcycle;
import com.projectweek2.model.Vehicle;

public class BbddInMemory {

    private BbddInMemory(){
    }

    private static List<Vehicle> listOfVehicles = getListOfVehiclesData();

    /**
     * Generamos una lista con vehiculos, de tipo Car, Motorcycle y Bicycle
     */
    public static List<Vehicle> getListOfVehiclesData() {
        ArrayList<Vehicle> list = new ArrayList<>();

        Vehicle car = new Car("Tesla", "S", 60_000, 250, new Motor(700, "electric"), 11111);
        Vehicle car2 = new Car("Toyota", "QW", 30_000, 200, new Motor(200, "diesel"), 22222);
        Vehicle car3 = new Car("Ferrari", "Roma", 300_000, 320, new Motor(900, "fuel"), 33333);

        Vehicle motorcylce1 = new Motorcycle("BMW", "x900", 12_000, 220, new Motor(200, "fuel"), 444444);
        Vehicle motorcylce2 = new Motorcycle("Yamaha", "700", 8_000, 220, new Motor(100, "fuel"), 555555);

        Vehicle bicycle = new Bicycle("Orbea", "89o", 1_000, 60);

        list.add(car);
        list.add(car2);
        list.add(car3);
        list.add(motorcylce1);
        list.add(motorcylce2);
        list.add(bicycle);

        return list;
    }

    public static List<Vehicle> getListOfVehicles() {
        return listOfVehicles;
    }

}
