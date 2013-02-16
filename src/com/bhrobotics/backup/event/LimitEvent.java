package com.bhrobotics.backup.event;

public class LimitEvent {
	private boolean state;
	
	public LimitEvent(boolean state) {
		this.state = state;
	}
	
	public boolean getState() {
		return state;
	}

}
