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

public class IntakeSubsystem extends SubsystemBase {
  Victor m_intakeMotor = new Victor(Constants.kPWMIntakePort);
  
  public IntakeSubsystem() {
    super();
    this.m_intakeMotor.setInverted(Constants.kIntakeMotorInverted);
    addChild("Intake motor", m_intakeMotor);
  }

  public void push() {
    this.m_intakeMotor.set(Constants.kIntakeSpeed);
  }
  
  public void pull() {
    this.m_intakeMotor.set(-Constants.kIntakeSpeed);
  }

  public void set(double speed) {
    this.m_intakeMotor.set(speed);
  }

  public void log() {
    SmartDashboard.putString("Intake",
        m_intakeMotor.get() > 0 ?
        "Intake pushing" : 
        m_intakeMotor.get() == 0 ? "Intake paused" : 
        "Intake pulling");
  }

  @Override
  public void periodic() {
    log();
  }
}
