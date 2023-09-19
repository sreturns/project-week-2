package com.projectweek2.model;

/**
 * Clase abstract que genera dos metodos abstractos
 * 
 * @see com.sinensia.project.entities.Car
 * @see com.sinensia.project.entities.Motorcycle
 * @see com.sinensia.project.entities.Bicycle
 */

public abstract class Vehicle {

	private static final int BEST_CONDITION = 100;
	private static int vehiclesNumber = 0;
	private int price;
	private int vehicleState;
	private int maxSpeed;
	private String brand = "";
	private String model = "";
	private int velocity;
	protected int numberOfWheels;

	/**
	 * Constructor que contabiliza el numero de vehiculos que se instancian
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 * @param maxSpeed
	 */
	protected Vehicle(String brand, String model, int price, int maxSpeed) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.maxSpeed = maxSpeed;
		this.vehicleState = BEST_CONDITION;
		vehiclesNumber++;
	}

	/**
	 * Obligamos a implementar este metodo a las clases que hereden de esta
	 */
	public abstract void repair();

	public abstract void acelerar();

	public abstract void smallShock();

	/**
	 * Inicia el motor en caso de tenerlo
	 */
	public abstract void initiateVehicle();

	/**
	 * Apaga el motor en caso de tenerlo
	 */
	public abstract void stopVehicle();

	public void decelerar() {
		setVelocity(getVelocity() - 10);
		if (velocity < 0) {
			velocity = 0;
		}
	}

	/**
	 * Getter statico para poder acceder a traves de la clase
	 */
	public static int getVehiclesNumber() {
		return vehiclesNumber;
	}

	public static void setVehiclesNumber(int vehiclesNumber) {
		Vehicle.vehiclesNumber = vehiclesNumber;
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

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	@Override
	public String toString() {
		return "Vehicle -> price=" + price + ", maxSpeed=" + maxSpeed + ", brand=" + brand + ", model=" + model
				+ ", numberOfWheels=" + numberOfWheels + "\n";
	}

}
