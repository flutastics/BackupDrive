package com.bhrobotics.backup.concreteobserver;

import com.bhrobotics.backup.event.AxisEvent;
import com.bhrobotics.backup.event.ButtonEvent;
import com.bhrobotics.backup.observer.AxisObserver;
import com.bhrobotics.backup.observer.ButtonObserver;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class Flywheel extends Observer implements AxisObserver, ButtonObserver {
	private Victor intakeHingeVictor;
	private Victor topConveyorVictor;
	private Victor bottomConveyorVictor;
	private Victor flywheelVictor;
	private Encoder intakeHingeEncoder;
	private double magnitude = 0;
	private double conveyorFireValue = 1.0;
	private double currentValue = intakeHingeEncoder.getDistance();
	private double goalValue;
	private IntakeHinge intakeHinge = new IntakeHinge(intakeHingeVictor, intakeHingeEncoder, currentValue, goalValue);
	
	public Flywheel(Victor intakeHingeVictor, Victor topConveyorVictor, Victor bottomConveyorVictor, Victor flywheelVictor, Encoder intakeHingeEncoder) {
		this.intakeHingeVictor = intakeHingeVictor;
		this.topConveyorVictor = topConveyorVictor;
		this.bottomConveyorVictor = bottomConveyorVictor;
		this.flywheelVictor = flywheelVictor;
		this.intakeHingeEncoder = intakeHingeEncoder;
	}

	public void call(ButtonEvent buttonEvent) {
		if (buttonEvent.getState()) {
			intakeHinge.setHinge();
			flywheelVictor.set(magnitude);
			topConveyorVictor.set(conveyorFireValue);
			bottomConveyorVictor.set(conveyorFireValue);
		}
	}

	public void call(AxisEvent axisEvent) {
		magnitude = axisEvent.getState();
	}

}
