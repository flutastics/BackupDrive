package com.bhrobotics.backup.concreteobserver;

import com.bhrobotics.backup.event.AxisEvent;
import com.bhrobotics.backup.observer.AxisObserver;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class IRingAxis extends Observer implements AxisObserver {
	private Victor intakeHingeVictor;
	private Encoder intakeHingeEncoder;
	private double currentValue = intakeHingeEncoder.getDistance();
	private double goalValue;
	private IntakeHinge intakeHinge;
	
	public IRingAxis (Victor intakeHingeVictor, Encoder intakeHingeEncoder) {
		this.intakeHingeVictor = intakeHingeVictor;
		this.intakeHingeEncoder = intakeHingeEncoder;
	}

	public void call(AxisEvent axisEvent) {
		goalValue = axisEvent.getState();
		intakeHinge = new IntakeHinge(intakeHingeVictor, intakeHingeEncoder, currentValue, goalValue);
		intakeHinge.setHinge();
	}

}
