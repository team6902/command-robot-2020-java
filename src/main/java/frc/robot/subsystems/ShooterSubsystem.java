/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

@Deprecated
public class ShooterSubsystem extends SubsystemBase {
  // private DoubleSolenoid m_doubleSolenoid = 
  //     new DoubleSolenoid(Constants.kPneumaticShooterPortForward,
  //     Constants.kPneumaticShooterPortBackward);
  
  // public Shooter() {
  //   super();
  //   addChild("Shooter solenoid", m_doubleSolenoid);
  // }

  // public void open() {
  //   this.m_doubleSolenoid.set(Value.kForward);
  // }
  
  // public void close() {
  //   this.m_doubleSolenoid.set(Value.kReverse);
  // }

  // public void log() {
  //   SmartDashboard.putString("Shooter",
  //       m_doubleSolenoid.get() == Value.kForward ?
  //       "Shooter open" : "Shooter closed");
  // }

  // @Override
  // public void periodic() {
  //   log();
  // }
}
