/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.bhrobotics.backup;


import com.bhrobotics.backup.concreteobserver.AButton;
import com.bhrobotics.backup.concreteobserver.BButton;
import com.bhrobotics.backup.concreteobserver.BackBottomButton;
import com.bhrobotics.backup.concreteobserver.BackTopButton;
import com.bhrobotics.backup.concreteobserver.CButton;
import com.bhrobotics.backup.concreteobserver.ERingButton;
import com.bhrobotics.backup.concreteobserver.Flywheel;
import com.bhrobotics.backup.concreteobserver.IRingAxis;
import com.bhrobotics.backup.concreteobserver.T1DownButton;
import com.bhrobotics.backup.emitter.AxisEmitter;
import com.bhrobotics.backup.emitter.ButtonEmitter;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class BackupBot extends IterativeRobot {
	private Joystick joystick;
	private MotorModule left;
	private MotorModule right;
	private DigitalInput valve;
	private Relay compressor;
    private ButtonEmitter aEmitter;
    private ButtonEmitter bEmitter;
    private ButtonEmitter cEmitter;
    private ButtonEmitter eRingEmitter;
    private ButtonEmitter t1DownEmitter;
    private ButtonEmitter flywheelEmitter;
    private ButtonEmitter backBottomEmitter;
    private ButtonEmitter backTopEmitter;
    private AxisEmitter iRingEmitter;
    private AButton aObserver;
    private BButton bObserver;
    private CButton cObserver;
    private ERingButton eRingObserver;
    private T1DownButton t1DownObserver;
    private Flywheel flywheelObserver;
    private BackBottomButton backBottomObserver;
    private BackTopButton backTopObserver;
    private IRingAxis iRingObserver;
    private Ticker ticker;
    
    public void robotInit() {
	joystick = new Joystick(1);
	left = new MotorModule(1,3,1,3);
	right = new MotorModule(2,4,2,4);
	valve = new DigitalInput(1,1);
	compressor = new Relay(1,1);
	aEmitter = new ButtonEmitter(joystick, 3);
	bEmitter = new ButtonEmitter(joystick, 4);
	cEmitter = new ButtonEmitter(joystick, 5);
	eRingEmitter = new ButtonEmitter(joystick, 8);
	t1DownEmitter = new ButtonEmitter(joystick, 10);
	flywheelEmitter = new ButtonEmitter(joystick, 2);
	backBottomEmitter = new ButtonEmitter(joystick, 6);
	backTopEmitter = new ButtonEmitter(joystick, 1);
	aEmitter.addObserver(aObserver);
	bEmitter.addObserver(bObserver);
	cEmitter.addObserver(cObserver);
	eRingEmitter.addObserver(eRingObserver);
	t1DownEmitter.addObserver(t1DownObserver);
	flywheelEmitter.addObserver(flywheelObserver);
	backBottomEmitter.addObserver(backBottomObserver);
	backTopEmitter.addObserver(backTopObserver);
	iRingEmitter.addObserver(iRingObserver);
	ticker.addTickable(aEmitter);
	ticker.addTickable(bEmitter);
	ticker.addTickable(cEmitter);
	ticker.addTickable(eRingEmitter);
	ticker.addTickable(t1DownEmitter);
	ticker.addTickable(flywheelEmitter);
	ticker.addTickable(backBottomEmitter);
	ticker.addTickable(backTopEmitter);
	ticker.start();
    }
    
    public void disabledInit() {
    	compressor.set(Relay.Value.kOff);
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	if(valve.get()) {
    		compressor.set(Relay.Value.kForward);
    	} else {
    		compressor.set(Relay.Value.kOff);
    	}
    
    	double angle = joystick.getDirectionRadians();
    	double magnitude = 0;
	
    	if(joystick.getMagnitude() > 0.1) {
    		magnitude = (1 - joystick.getRawAxis(3))/2;
    	}
	
    	double x = magnitude * Math.sin(angle);
    	double y = magnitude * Math.cos(angle);
    	double iRing = joystick.getRawAxis(4);
	
    	iRingEmitter = new AxisEmitter(iRing);
    	iRingEmitter.alert();
    	left.set(y - x);
    	right.set(y + x);
    	System.out.println(debugString());
    	}
    
    	public String debugString() {
    		return "[left]:" + left.get() + "[right]:" + right.get();  
    	}
}