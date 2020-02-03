/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ControlPanelSubsystem extends SubsystemBase {

  Victor m_rotationMotor = new Victor(Constants.kPWMPanelPortRotation);
  
  public ControlPanelSubsystem() {
    super();
    this.m_rotationMotor.setInverted(Constants.kControlPanelMotorInverted);
    addChild("Control panel motor", m_rotationMotor);
  }

  public void set(double speed) {
    this.m_rotationMotor.set(speed);
  }

  public void log() {
    SmartDashboard.putNumber("Rotation motor (CP)",
      m_rotationMotor.get());
  }

  @Override
  public void periodic() {
    log();
  }
}
