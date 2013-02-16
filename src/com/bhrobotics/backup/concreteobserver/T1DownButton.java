package com.bhrobotics.backup.concreteobserver;

import com.bhrobotics.backup.event.ButtonEvent;
import com.bhrobotics.backup.observer.ButtonObserver;

import edu.wpi.first.wpilibj.Victor;

public class T1DownButton extends Observer implements ButtonObserver {
	private Victor victor1;
	private Victor victor2;
	private double intakeMotorValue = 1.0;
	
	public T1DownButton(Victor victor1, Victor victor2) {
		this.victor1 = victor1;
		this.victor2 = victor2;
	}

	public void call(ButtonEvent buttonEvent) {
		if (buttonEvent.getState()) {
			victor1.set(intakeMotorValue);
			victor2.set(intakeMotorValue);
		}
	}

}
