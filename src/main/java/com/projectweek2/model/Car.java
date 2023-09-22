package com.projectweek2.model;

import java.util.Objects;

/**
 * Entidad coche
 * 
 * @see com.projectweek2.controllers.CarController
 * @see com.projectweek2.controllers.ApiCarController
 * @see com.projectweek2.repositories.BbddInMemory
 */
public class Car {

    private static int count = 0;
    private int id;

    private String brand;
    private String model;
    private int price;
    private int horsePower;
    private String motorType;

    public Car() {
    }

    /**
     * 
     * @param brand
     * @param model
     * @param price
     * @param horsePower
     * @param motorType
     */
    public Car(String brand, String model, int price, int horsePower, String motorType) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.horsePower = horsePower;
        this.motorType = motorType;
        this.id = count;
        count++;
    }

    /**
     * Definimos nuestro metodo equals para comparar los coches
     * 
     * @param obj
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car)) {
            return false;
        }
        Car car = (Car) obj;
        return id == car.id && brand.equals(car.brand) && model.equals(car.model)
                && price == car.price && horsePower == car.horsePower
                && motorType.equals(car.motorType);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getMotorType() {
        return motorType;
    }

    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Car.count = count;
    }

}
