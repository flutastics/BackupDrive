package com.bhrobotics.backup.emitter;

import com.bhrobotics.backup.concreteobserver.Observer;

public interface Emitter {
	
	public void addObserver(Observer observer);
	
	public void alert();
	
}
