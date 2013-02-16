package com.bhrobotics.backup.observer;

import com.bhrobotics.backup.event.AxisEvent;

public interface AxisObserver {

	public void call (AxisEvent axisEvent);
	
}
