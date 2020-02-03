/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSubsystem extends SubsystemBase {
 
  // Uncomment this if using two PWM wires
  // private SpeedControllerGroup m_climbMotors = 
  //     new SpeedControllerGroup(
  //     new Talon(Constants.kPWMClimbPort),
  //     new Talon(Constants.kPWMClimbPort2));
  
  private Talon m_climbMotors = 
      new Talon(Constants.kPWMClimbPort);
    
  private DoubleSolenoid m_doubleSolenoid = 
      new DoubleSolenoid(Constants.kPneumaticClimbPortForward,
      Constants.kPneumaticClimbPortBackward);

  public ClimbSubsystem() {
    super();
    this.m_climbMotors.setInverted(Constants.kClimbMotorInverted);
    addChild("Climb motors", m_climbMotors);
  }

  public void log() {
    SmartDashboard.putString("Climbing",
        m_climbMotors.get() > 0 ? "Up" :
        m_climbMotors.get() == 0 ? "Stopped"
        : "Down");
    SmartDashboard.putString("Claw",
        m_doubleSolenoid.get() == Value.kForward ? 
        "Open" : "Closed");
  }

  public void up() {
    m_climbMotors.set(Constants.kClimbSpeed);
  }
  
  public void hold() {
    m_climbMotors.set(Constants.kClimbHoldSpeed);
  }

  public void down() {
    m_climbMotors.set(Constants.kClimbReverseSpeed);
  }

  public void stop() {
    m_climbMotors.stopMotor();
  }

  public void openClaw() {
    m_doubleSolenoid.set(Value.kForward);
  }

  public void closeClaw() {
    m_doubleSolenoid.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    log();
  }
}
