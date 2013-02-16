package com.bhrobotics.backup.concreteobserver;

import com.bhrobotics.backup.MotorModule;
import com.bhrobotics.backup.event.ButtonEvent;
import com.bhrobotics.backup.observer.ButtonObserver;

public class BButton extends Observer implements ButtonObserver {
	private MotorModule left;
	private MotorModule right;
	
	public BButton(MotorModule left,MotorModule right) {
		this.left = left;
		this.right = right;
	}
	
	public void call(ButtonEvent buttonEvent) {
		if (buttonEvent.getState()) {
			left.setLowSpeed();
			right.setLowSpeed();
		}
	}

}
