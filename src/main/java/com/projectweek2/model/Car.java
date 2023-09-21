package com.projectweek2.model;

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

    public Car(String brand, String model, int price, int horsePower, String motorType) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.horsePower = horsePower;
        this.motorType = motorType;
        this.id = count;
        count++;
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
}

