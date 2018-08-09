/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5638.robot.subsystems;

import org.usfirst.frc.team5638.robot.Robot;
import org.usfirst.frc.team5638.robot.RobotMap;
import org.usfirst.frc.team5638.robot.commands.driveCom;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveSub extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
    private final WPI_VictorSPX victorSPXleft = RobotMap.driveTrainVictorSPXleft;
    private final WPI_TalonSRX talonSRXleft = RobotMap.driveTrainTalonSRXleft;
    private final SpeedControllerGroup leftGearbox = RobotMap.driveTrainleftGearbox;
    private final WPI_VictorSPX victorSPXright = RobotMap.driveTrainVictorSPXright;
    private final WPI_TalonSRX talonSRXright = RobotMap.driveTrainTalonSRXright;
    private final SpeedControllerGroup rightGearbox = RobotMap.driveTrainrightGearbox;
    private final DifferentialDrive driveTrain = RobotMap.driveTrain;

	
	double steer = Robot.m_oi.steerStick;
	double forward = Robot.m_oi.forwardThrottle;
	double reverse = Robot.m_oi.reverseThrottle;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new driveCom());
	}
	
	
	
	//main operator controlled drive
	public void drive() {
		driveTrain.arcadeDrive(reverse + forward, steer);
	}
	
	public void stop() {
		driveTrain.arcadeDrive(0, 0);
	}
}
