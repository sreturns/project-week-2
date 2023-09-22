package com.projectweek2.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.projectweek2.model.Car;

public class BbddInMemory {

    private BbddInMemory() {
    }

    private static List<Car> listOfCars = getListOfVehiclesData();

    /**
     * Generamos una lista con vehiculos para trabajar con ella durante la ejecucion
     * de la aplicacion
     * 
     * @see com.projectweek2.model.Car
     * @see com.projectweek2.repositories.BbddInMemory
     * @see com.projectweek2.controllers.MainPageController
     * @see com.projectweek2.controllers.ApiCarController
     * @see com.projectweek2.controllers.CarController
     */
    private static List<Car> getListOfVehiclesData() {
        ArrayList<Car> list = new ArrayList<>();

        Car car1 = new Car("Tesla", "S", 80_000, 500, "Electric");
        Car car2 = new Car("Tesla", "X", 70_000, 5000, "Electric");
        Car car3 = new Car("BMW", "M5", 120_000, 700, "Fuel");
        Car car4 = new Car("Audi", "RS6", 200_000, 750, "Fuel");
        Car car5 = new Car("Mercedes", "EQ", 90_000, 600, "Electric");
        Car car6 = new Car("Cupra", "Rebel", 40_000, 250, "Fuel");
        Car car7 = new Car("Ferrari", "Roma", 300_000, 800, "Hybrid");

        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);
        list.add(car5);
        list.add(car6);
        list.add(car7);

        return list;
    }

    public static List<Car> getListOfVehicles() {
        return listOfCars;
    }

    /**
     * Guardamos un coche en la BBDD y gestionamos el recuento del id
     * 
     * @param car
     */
    public static void saveCar(Car car) {
        car.setId(Car.getCount()); // Establece el ID usando el valor actual de getCount()
        listOfCars.add(car);
        Car.setCount(Car.getCount() + 1); // Incrementa el contador después de guardar el coche
    }

    /**
     * Hacemos delete de un coche a traves de su id
     * 
     * @param id
     */
    public static void deleteCar(int id) {
        // Buscamos el coche a traves del id
        Optional<Car> carToRemove = listOfCars.stream().filter(car -> car.getId() == id).findFirst();

        if (carToRemove.isPresent()) {
            // Si se encuentra el coche, lo eliminamos de la lista
            listOfCars.remove(carToRemove.get());
        }
    }

    /**
     * Buscamos un coche a traves de su id y lo devolvemos
     * 
     * @param id
     * @return car
     */
    public static Car findById(int id) {
        for (Car car : listOfCars) {
            if (id == car.getId()) {
                return car;
            }
        }
        return null;
    }

    /**
     * Si encontramos el id del coche, lo actualizamos con los parametros nuevos
     * 
     * @param updatedCar
     */
    public static void updateCar(Car updatedCar) {

        Car existingCar = findById(updatedCar.getId());

        if (existingCar != null) {
            // Actualizar los campos del coche existente con los datos del coche
            // actualizado
            existingCar.setId(updatedCar.getId());
            existingCar.setBrand(updatedCar.getBrand());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setPrice(updatedCar.getPrice());
            existingCar.setMotorType(updatedCar.getMotorType());
            existingCar.setHorsePower(updatedCar.getHorsePower());
        }
    }

    /**
     * Devolvemos el tamaño de la lista
     */
    public static int getListSize() {
        return listOfCars.size();
    }
}
