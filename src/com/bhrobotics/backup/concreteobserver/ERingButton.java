package com.bhrobotics.backup.concreteobserver;

import com.bhrobotics.backup.event.ButtonEvent;
import com.bhrobotics.backup.observer.ButtonObserver;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class ERingButton extends Observer implements ButtonObserver {
	private Victor intakeHingeVictor;
	private Victor topConveyorVictor;
	private Victor bottomConveyorVictor;
	private Victor flywheelVictor;
	private Encoder intakeHingeEncoder;
	private double conveyorFlushValue = -1.0;
	private double currentValue = intakeHingeEncoder.getDistance();
	private double goalValue;
	private IntakeHinge intakeHinge = new IntakeHinge(intakeHingeVictor, intakeHingeEncoder, currentValue, goalValue);
	
	public ERingButton(Victor intakeHingeVictor, Victor topConveyorVictor, Victor bottomConveyorVictor, Victor flywheelVictor, Encoder intakeHingeEncoder) {
		this.intakeHingeVictor = intakeHingeVictor;
		this.topConveyorVictor = topConveyorVictor;
		this.bottomConveyorVictor = bottomConveyorVictor;
		this.flywheelVictor = flywheelVictor;
		this.intakeHingeEncoder = intakeHingeEncoder;
	}
	
	public void call(ButtonEvent buttonEvent) {
		if (buttonEvent.getState()) {
			intakeHinge.setHinge();
			flywheelVictor.set(conveyorFlushValue);
			topConveyorVictor.set(conveyorFlushValue);
			bottomConveyorVictor.set(conveyorFlushValue);
		}
	}

}
