package com.bhrobotics.backup.emitter;

import java.util.Enumeration;
import java.util.Vector;

import com.bhrobotics.backup.event.LimitEvent;
import com.bhrobotics.backup.concreteobserver.Observer;
import com.bhrobotics.backup.observer.LimitObserver;

public class LimitEmitter implements Emitter {
	private Vector limitObservers = new Vector();
	private boolean isSwitched = false;

	public void addObserver(Observer observer) {
		limitObservers.addElement(observer);
	}

	public void alert() {
		Enumeration e = limitObservers.elements();
		while(e.hasMoreElements()) {
			((LimitObserver)e.nextElement()).call(new LimitEvent(isSwitched));
		}
	}

}
