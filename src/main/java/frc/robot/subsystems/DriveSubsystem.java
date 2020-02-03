/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  private final SpeedController m_leftMotor =
      new Spark(Constants.kPWMDriveMotorLeftPort);
  private final SpeedController m_rightMotor =
      new Spark(Constants.kPWMDriveMotorRightPort);

  private final DifferentialDrive m_drive = 
      new DifferentialDrive(m_leftMotor, m_rightMotor);

  private final AnalogInput m_rangeFinder = 
      new AnalogInput(Constants.kAnalogInInfraredPort);

  private final AHRS m_gyro = 
      new AHRS(Constants.kNavXPort);

  public DriveSubsystem() {
    super();
    this.m_leftMotor.setInverted(Constants.kDriveLeftInverted);
    this.m_rightMotor.setInverted(Constants.kDriveRightInverted);
    addChild("Drive", m_drive);
    addChild("Rangefinder", m_rangeFinder);
    addChild("Gyro", m_gyro);
  }

  public void log() {
    SmartDashboard.putNumber("Gyro", m_gyro.getAngle());
  }

  public void tankDrive(double left, double right) {
    m_drive.tankDrive(left, right, true);
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    m_drive.arcadeDrive(xSpeed, zRotation, true);
  }

  public double getHeading() {
    return m_gyro.pidGet();
  }

  public void reset() {
    m_gyro.reset();
  }
  
  public double getDistance() {
    return m_gyro.getDisplacementX();
  }

  public double getDistanceToObstacle() {
    return m_rangeFinder.getAverageVoltage();
  }

  @Override
  public void periodic() {
    log();
  }
}
