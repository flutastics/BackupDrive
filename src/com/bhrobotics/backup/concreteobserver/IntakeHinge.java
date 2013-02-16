package com.bhrobotics.backup.concreteobserver;

import com.bhrobotics.backup.Ticker;
import com.bhrobotics.backup.tickables.EncoderDisplacementValueTickable;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class IntakeHinge {
	private Victor hingeVictor;
	private Encoder hingeEncoder;
	private double currentValue;
	private double goalValue;

	public IntakeHinge (Victor hingeVictor, Encoder hingeEncoder, double currentValue, double goalValue) {
		this.hingeVictor = hingeVictor;
		this.hingeEncoder = hingeEncoder;
		this.currentValue = currentValue;
		this.goalValue = goalValue;
	}
	
	private Ticker positionTicker = new Ticker();
	private EncoderDisplacementValueTickable tickable = new EncoderDisplacementValueTickable(hingeVictor, hingeEncoder, currentValue, goalValue);
	 
	 
	
	public void setHinge() {
		positionTicker.addTickable(tickable);
		positionTicker.start();
	}

}
