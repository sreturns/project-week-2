package com.projectweek2.model;

import java.util.Objects;

import com.projectweek2.interfaces.Startable;

/**
 * Clase que extiende de vehiculo y ademas implemente el parametro motor
 * 
 * @see com.sinensia.project.entities.motor
 * @see com.sinensia.project.entities.Vehicle
 * @see com.sinensia.project.interfaces.Startable
 */
public final class Car extends Vehicle implements Startable {

	private static int numberOfCars = 0;
	private static final int CAR_WHEEL_NUMBER = 4;
	private static final int TOP_SPEED = 400;

	private Motor motor;
	private int matricula;
	private int velocity;

	/**
	 * Indicamos el numero de ruedas con la variable statica final CAR_WHEEL_NUMBER
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 * @param maxSpeed
	 * @param motor
	 * @param matricula
	 */
	public Car(String brand, String model, int price, int maxSpeed, Motor motor, int matricula) {
		super(brand, model, price, maxSpeed);
		numberOfWheels = CAR_WHEEL_NUMBER;
		this.motor = motor;
		this.matricula = matricula;
		numberOfCars++;

		if (maxSpeed > TOP_SPEED) {
			maxSpeed = TOP_SPEED;
		}
	}

	/**
	 * Sobrecargamos el metodo equals para comparar el objecto Car a traves de su
	 * matricula
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
		return Objects.equals(matricula, car.getMatricula());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(matricula);
	}

	/**
	 * Acelera el vehiculo de 50 en 50, y comprueba que no pase la velocidad maximo
	 * 
	 * @see com.sinensia.project.entities.Vehicle
	 */
	@Override
	public void acelerar() {
		if (motor.isState()) {
			setVelocity(getVelocity() + 50);
			if (velocity > TOP_SPEED) {
				velocity = TOP_SPEED;
			}
		} else {
			System.out.println("El motor esta apagado, enciendelo");
		}
	}

	/**
	 * Decelera el vehiculo de 20 en 20, y comprueba que cuando estes a 0 no puedas
	 * bajar mas
	 * 
	 * @see com.sinensia.project.entities.Vehicle
	 */
	@Override
	public void decelerar() {
		if (motor.isState()) {
			setVelocity(getVelocity() - 20);
			if (velocity < 0) {
				velocity = 0;
				System.out.println("No puedes bajar mas la velocidad, esta a 0");
			}
		} else {
			System.out.println("El motor esta apagado, no puedes decelerar");
		}
	}

	/**
	 * Llamo al metodo que implemento a traves de la interfaz Starttable
	 * 
	 * @see com.sinensia.project.interfaces.Startable
	 */
	public void initiateVehicle() {
		startUp(motor);
	}

	/**
	 * Llamo al metodo que implemento a traves de la interfaz Starttable
	 * 
	 * @see com.sinensia.project.interfaces.Startable
	 */
	public void stopVehicle() {
		turnOfMotor(motor);
		setVelocity(0);
	}

	@Override
	public void repair() {
		// TODO Auto-generated method stub

	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	@Override
	public void setMaxSpeed(int maxSpeed) {
		if (maxSpeed >= TOP_SPEED) {
			maxSpeed = TOP_SPEED;
		}
	}

	@Override
	public void startUp(Motor motor) {
		motor.setState(true);
	}

	@Override
	public void turnOfMotor(Motor motor) {
		motor.setState(false);
	}

	@Override
	public void smallShock() {
		// TODO
	}

	public static int getNumberOfCars() {
		return numberOfCars;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
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
