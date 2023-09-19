package com.projectweek2.model;

public class DealerShip<T extends Vehicle> {

    private T vehicle;

    public DealerShip() {
    }

    public DealerShip(T vehicle) {
        this.vehicle = vehicle;
    }

    public T getVehicle() {
        return vehicle;
    }

    public void setVehicle(T vehicle) {
        this.vehicle = vehicle;
    }
}
