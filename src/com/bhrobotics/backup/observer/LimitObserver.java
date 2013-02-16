package com.bhrobotics.backup.observer;

import com.bhrobotics.backup.event.LimitEvent;

public interface LimitObserver {
	
	public LimitEvent call(LimitEvent limitEvent);

}
