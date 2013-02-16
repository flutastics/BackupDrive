package com.bhrobotics.backup.concreteobserver;

import com.bhrobotics.backup.event.ButtonEvent;
import com.bhrobotics.backup.observer.ButtonObserver;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class BackBottomButton extends Observer implements ButtonObserver {
	private Victor intakeHingeVictor;
	private Encoder intakeHingeEncoder;
	private double currentValue = intakeHingeEncoder.getDistance();
	private double goalValue;
	private IntakeHinge intakeHinge = new IntakeHinge(intakeHingeVictor, intakeHingeEncoder, currentValue, goalValue);
	
	public BackBottomButton(Victor intakeHingeVictor, Encoder intakeHingeEncoder) {
		this.intakeHingeVictor = intakeHingeVictor;
		this.intakeHingeEncoder = intakeHingeEncoder;
	}

	public void call(ButtonEvent buttonEvent) {
		if (buttonEvent.getState()) {
			intakeHinge.setHinge();
		}
	}

}
