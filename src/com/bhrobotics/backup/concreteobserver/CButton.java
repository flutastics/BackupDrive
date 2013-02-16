package com.bhrobotics.backup.concreteobserver;

import com.bhrobotics.backup.event.ButtonEvent;
import com.bhrobotics.backup.observer.ButtonObserver;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class CButton extends Observer implements ButtonObserver {
	private Victor intakeHingeVictor;
	private Encoder intakeHingeEncoder;
	private double feederIntakePositionValue;
	private double downwardMotorValue = 1.0;
	private double upwardMotorValue = -1.0;
	
	public CButton(Victor intakeHingeVictor, Encoder intakeHingeEncoder) {
		this.intakeHingeVictor = intakeHingeVictor;
		this.intakeHingeEncoder = intakeHingeEncoder;
	}

	public void call(ButtonEvent buttonEvent) {
		if (buttonEvent.getState()) {
			if (intakeHingeEncoder.getDistance() < feederIntakePositionValue) {
				if (intakeHingeEncoder.getDirection() == false) {
					intakeHingeEncoder.setReverseDirection(false);
				}
				intakeHingeVictor.set(downwardMotorValue);
				while (intakeHingeEncoder.getDistance() <= feederIntakePositionValue) {
					if (intakeHingeEncoder.getDistance() == feederIntakePositionValue) {
						intakeHingeVictor.set(0);
					}
				}
			} else if (intakeHingeEncoder.getDistance() > feederIntakePositionValue) {
				if (intakeHingeEncoder.getDirection()) {
					intakeHingeEncoder.setReverseDirection(true);
				}
				intakeHingeVictor.set(upwardMotorValue);
				while (intakeHingeEncoder.getDistance() >= feederIntakePositionValue) {
					if (intakeHingeEncoder.getDistance() == feederIntakePositionValue) {
						intakeHingeVictor.set(0);
					}
				}
			}
		}
	}

}
