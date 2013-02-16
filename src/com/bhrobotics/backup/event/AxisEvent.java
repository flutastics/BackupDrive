package com.bhrobotics.backup.event;

public class AxisEvent {
	private double state;

	public AxisEvent(double state) {
		this.state = state;
	}
	
	public double getState() {
		return state;
	}
	
}
