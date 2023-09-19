package com.projectweek2.interfaces;

import com.projectweek2.model.Motor;

/**
 * Esta interfaz indica que las clase donde lo implementemos (Coche y Moto)
 * deben poder encender y apagar el motor
 * 
 * @see com.sinensia.project.entities.Car
 * @see com.sinensia.project.entities.Motorcycle
 */
public interface Startable {

	void startUp(Motor motor);

	void turnOfMotor(Motor motor);

}
