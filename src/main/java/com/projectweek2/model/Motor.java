package com.projectweek2.model;;

public class Motor {

	private int horsePower;
	private String motorType = "";
	private boolean state;

	public Motor(int horsePower, String motorType) {
		this.horsePower = horsePower;
		this.motorType = motorType;
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

	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
}
