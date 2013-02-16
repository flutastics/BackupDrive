package com.bhrobotics.backup.event;

public class ButtonEvent {
	private boolean state;

	public ButtonEvent(boolean state) {
		this.state = state;
	}
	
	public boolean getState() {
		return state;
	}

}
