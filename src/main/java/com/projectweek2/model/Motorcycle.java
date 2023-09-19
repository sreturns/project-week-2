package com.projectweek2.model;

import java.util.Objects;

import com.projectweek2.interfaces.Startable;



/**
 * Clase que extiende de Vehicle y que implementa Startable
 * 
 * @see com.sinensia.project.entities.Car
 * @see com.sinensia.project.entities.Bicycle
 * @see com.sinensia.project.interfaces.Startable
 */
public final class Motorcycle extends Vehicle implements Startable {

	private static int numberOfMotorcycles = 0;
	private static final int MOTORCYCLE_WHEELS_NUMBER = 2;
	private static final int TOP_SPEED = 350;

	private Motor motor;
	private int matricula;
	private int velocity;

	/**
	 * Constrructor para iniciar una instancia de la clase
	 * 
	 * @param brand
	 * @param model
	 * @param price
	 * @param maxSpeed
	 * @param motor
	 * @param matricula
	 */
	public Motorcycle(String brand, String model, int price, int maxSpeed, Motor motor, int matricula) {
		super(brand, model, price, maxSpeed);
		this.setMotor(motor);
		this.numberOfWheels = MOTORCYCLE_WHEELS_NUMBER;
		this.matricula = matricula;
		numberOfMotorcycles++;

		if (maxSpeed > TOP_SPEED) {
			maxSpeed = TOP_SPEED;
		}
	}

	/**
	 * Metodo equals sobrecargado para comparar la matricula de un objecto de tipo
	 * Motorcyle
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Motorcycle)) {
			return false;
		}

		Motorcycle motorcycle = (Motorcycle) o;
		return Objects.equals(matricula, motorcycle.getMatricula());
	}

	public int hashCode() {
		return Objects.hashCode(matricula);
	}

	/**
	 * Metodo de la interfaz Startable, inicia el motor
	 * 
	 * @see com.sinensia.project.interfaces.Startable
	 */
	@Override
	public void startUp(Motor motor) {
		motor.setState(true);
	}

	/**
	 * Metodo para controlar el tope de velocidad
	 * 
	 * @see com.sinensia.project.entities.Vehicle
	 */
	@Override
	public void setMaxSpeed(int maxSpeed) {
		if (maxSpeed >= TOP_SPEED) {
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
	 * Decelera el vehiculo de 30 en 30, y comprueba que cuando estes a 0 no puedas
	 * bajar mas
	 * 
	 * @see com.sinensia.project.entities.Vehicle
	 */
	public void decelerar() {
		setVelocity(getVelocity() - 30);
		if (velocity < 0) {
			velocity = 0;
			System.out.println("No puedes bajar mas la velocidad, esta a 0");
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
	public void turnOfMotor(Motor motor) {
		motor.setState(false);
	}

	@Override
	public void smallShock() {
		// TODO
	}

	@Override
	public void repair() {
		// TODO Auto-generated method stub

	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public static int getNumberOfMotorcycles() {
		return numberOfMotorcycles;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

}
