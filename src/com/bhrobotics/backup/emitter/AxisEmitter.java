package com.bhrobotics.backup.emitter;

import java.util.Enumeration;
import java.util.Vector;

import com.bhrobotics.backup.event.AxisEvent;
import com.bhrobotics.backup.concreteobserver.Observer;
import com.bhrobotics.backup.observer.AxisObserver;

public class AxisEmitter implements Emitter {
	private Vector axisObservers = new Vector();
	private double axisValue;
	
	public AxisEmitter (double axisValue) {
		this.axisValue = axisValue;
	}
	
	public void addObserver(Observer observer) {
		axisObservers.addElement(observer);
	}
	
	public void alert() {
		Enumeration e = axisObservers.elements();
		while(e.hasMoreElements()) {
			((AxisObserver)e.nextElement()).call(new AxisEvent(axisValue));
		}
	}

}
