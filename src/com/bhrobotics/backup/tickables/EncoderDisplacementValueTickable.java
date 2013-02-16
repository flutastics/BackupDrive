package com.bhrobotics.backup.tickables;

import com.bhrobotics.backup.Tickable;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

public class EncoderDisplacementValueTickable implements Tickable {
	private Victor hingeVictor;
	private Encoder hingeEncoder;
	private double currentValue;
	private double goalValue;
	
	public EncoderDisplacementValueTickable (Victor hingeVictor, Encoder hingeEncoder, double currentValue, double goalValue) {
		this.hingeVictor = hingeVictor;
		this.hingeEncoder = hingeEncoder;
		this.currentValue = currentValue;
		this.goalValue = goalValue;
	}

	public void tick() {
		if (currentValue < goalValue) {
			hingeVictor.set(1.0);
			currentValue += hingeEncoder.getDistance();
			hingeEncoder.reset();
		} else if (currentValue > goalValue) {
			hingeVictor.set(-1.0);
			currentValue -= hingeEncoder.getDistance();
			hingeEncoder.reset();
		} else {
			hingeVictor.set(0);
		}
	}

}
