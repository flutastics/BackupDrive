package com.bhrobotics.backup.emitter;

import java.util.Enumeration;
import java.util.Vector;

import com.bhrobotics.backup.Tickable;
import com.bhrobotics.backup.concreteobserver.Observer;
import com.bhrobotics.backup.event.ButtonEvent;
import com.bhrobotics.backup.observer.ButtonObserver;

import edu.wpi.first.wpilibj.Joystick;

public class ButtonEmitter implements Emitter, Tickable {	
	private Vector buttonObservers = new Vector();
	private boolean isPressed = false;
	private Joystick control;
	private int channel;
	
	public ButtonEmitter(Joystick joystick, int channel) {
		this.channel = channel;
		control = joystick;
	}
	
	public void addObserver(Observer observer) {
		buttonObservers.addElement(observer);
	}

	public void alert() {
		Enumeration e = buttonObservers.elements();
		while(e.hasMoreElements()) {
			((ButtonObserver)e.nextElement()).call(new ButtonEvent(isPressed));
		}
	}
	
	public void tick() {
		boolean state = control.getRawButton(channel);
		if(isPressed != state) {
			isPressed = state;
			alert();
		}
			
	}

}