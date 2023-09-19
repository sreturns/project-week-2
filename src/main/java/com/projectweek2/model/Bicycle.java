package com.projectweek2.model;

/**
 * Clase que hereda de Vehicle y que a diferencia de Moto y Car no tiene el
 * atributo Motor
 * 
 * @see com.sinensia.project.entities.Vehicle
 * @see com.sinensia.project.entities.Car
 * @see com.sinensia.project.entities.Bicycle
 */
public final class Bicycle extends Vehicle {

	private static int numberOfBicycles = 0;
	private static final int TOP_SPEED = 60;
	private static final int BICYCLE_WHEEL_NUMBER = 2;
	private int numberOfGears;
	private int velocity;
	private boolean lockedBicycle;
	private boolean canAccelerate = false;

	/**
	 * Comprobamos la velocidad maxima no supere la permitida
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 * @param maxSpeed
	 */
	public Bicycle(String brand, String model, int price, int maxSpeed) {
		super(brand, model, price, maxSpeed);
		this.numberOfWheels = BICYCLE_WHEEL_NUMBER;
		numberOfBicycles++;

		if (maxSpeed > TOP_SPEED) {
			maxSpeed = TOP_SPEED;
		}
	}

	/**
	 * Acelera el vehiculo de 50 en 50, y comprueba que no pase la velocidad maximo
	 * 
	 * @see com.sinensia.project.entities.Vehicle
	 */
	@Override
	public void acelerar() {
		if (canAccelerate) {
			setVelocity(getVelocity() + 10);
			if (velocity > TOP_SPEED) {
				velocity = TOP_SPEED;
			}
		} else {
			System.out.println("Necesitas quitar el candado");
		}
	}

	/**
	 * Decelera el vehiculo de 5 en 5, y comprueba que cuando estes a 0 no puedas
	 * bajar mas
	 * 
	 * @see com.sinensia.project.entities.Vehicle
	 */
	@Override
	public void decelerar() {
		if (canAccelerate) {
			setVelocity(getVelocity() - 5);
			if (velocity < 0) {
				velocity = 0;
				System.out.println("No puedes bajar mas la velocidad, esta a 0");
			}
		} else {
			System.out.println("No estas en la bici");
		}
	}

	@Override
	public void repair() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaxSpeed(int maxSpeed) {
		if (maxSpeed >= TOP_SPEED) {
			maxSpeed = TOP_SPEED;
		}
	}

	public void initiateVehicle() {
		canAccelerate = true;
	}

	public void stopVehicle() {
		canAccelerate = false;
	}

	public void lockBicycle() {
		lockedBicycle = true;
	}

	@Override
	public void smallShock() {

	}

	public int getNumberOfGears() {
		return numberOfGears;
	}

	public void setNumberOfGears(int numberOfGears) {
		this.numberOfGears = numberOfGears;
	}

	public static int getTopSpeed() {
		return TOP_SPEED;
	}

	public static int getBicycleWheelNumber() {
		return BICYCLE_WHEEL_NUMBER;
	}

	public static int getNumberOfBicycles() {
		return numberOfBicycles;
	}

	@Override
	public int getVelocity() {
		return velocity;
	}

	@Override
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

}
