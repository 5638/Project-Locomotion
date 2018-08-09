/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5638.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static WPI_VictorSPX driveTrainVictorSPXleft;
	public static WPI_TalonSRX driveTrainTalonSRXleft;
	public static SpeedControllerGroup driveTrainleftGearbox;
	public static WPI_VictorSPX driveTrainVictorSPXright;
	public static WPI_TalonSRX driveTrainTalonSRXright;
	public static SpeedControllerGroup driveTrainrightGearbox;
	public static DifferentialDrive driveTrain;
	
	public static void init() {
		 driveTrainTalonSRXleft = new WPI_TalonSRX(2);
	     driveTrainTalonSRXleft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
	     driveTrainTalonSRXleft.setSensorPhase(true);
	     driveTrainTalonSRXleft.setSafetyEnabled(false);
	   	 driveTrainTalonSRXleft.configNominalOutputForward(0, 10);
	 	 driveTrainTalonSRXleft.configNominalOutputReverse(0, 10);
	 	 driveTrainTalonSRXleft.configPeakOutputForward(1, 10);
	 	 driveTrainTalonSRXleft.configPeakOutputReverse(-1, 10);
	        
	 	 driveTrainVictorSPXleft = new WPI_VictorSPX(3);
	 	 driveTrainVictorSPXleft.follow(driveTrainTalonSRXleft);
	        
	 	 driveTrainleftGearbox = new SpeedControllerGroup(driveTrainTalonSRXleft, driveTrainVictorSPXleft);
	 	 
	 	 driveTrainTalonSRXright = new WPI_TalonSRX(4);
	     driveTrainTalonSRXright.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
	     driveTrainTalonSRXright.setSensorPhase(true);
	     driveTrainTalonSRXright.setSafetyEnabled(false);
	   	 driveTrainTalonSRXright.configNominalOutputForward(0, 10);
	 	 driveTrainTalonSRXright.configNominalOutputReverse(0, 10);
	 	 driveTrainTalonSRXright.configPeakOutputForward(1, 10);
	 	 driveTrainTalonSRXright.configPeakOutputReverse(-1, 10);
	        
	 	 driveTrainVictorSPXright = new WPI_VictorSPX(5);
	 	 driveTrainVictorSPXright.follow(driveTrainTalonSRXright);
	        
	 	 driveTrainrightGearbox = new SpeedControllerGroup(driveTrainTalonSRXright, driveTrainVictorSPXright);
	 	 
	 	 driveTrain = new DifferentialDrive(driveTrainleftGearbox, driveTrainrightGearbox);
	 	 driveTrain.setSafetyEnabled(false);
	 	 driveTrain.setExpiration(.1);
	 	 driveTrain.setMaxOutput(1.0);
	 	 driveTrain.setDeadband(.1);
	}
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
