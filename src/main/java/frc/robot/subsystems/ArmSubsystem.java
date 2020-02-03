/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  
  private Talon m_armMotor = 
      new Talon(Constants.kPWMArmPort);
  private final Encoder m_armEncoder =
      new Encoder(Constants.kDIOEncoderAPort, Constants.kDIOEncoderBPort, 
      false, CounterBase.EncodingType.k4X);

  public ArmSubsystem() {
    super();
    this.m_armMotor.setInverted(Constants.kClimbMotorInverted);
    this.m_armEncoder.setDistancePerPulse(Constants.kArmEncoderDistancePerPulse);
    addChild("Arm motor", m_armMotor);
    addChild("Arm encoder", m_armEncoder);
  }
  
  public void up() {
    m_armMotor.set(Constants.kClimbSpeed);
  }

  public void down() {
    m_armMotor.set(Constants.kClimbReverseSpeed);
  }

  public void set(double value) {
    m_armMotor.set(value);
  }

  public void stop() {
    m_armMotor.stopMotor();
  }

  public double pidGet() {
    return m_armEncoder.get();
  }

  public void log() {
    SmartDashboard.putNumber("Motor PWM", m_armMotor.get());
    SmartDashboard.putNumber("Encoder raw", m_armEncoder.get());
    SmartDashboard.putNumber("Encoder distance", m_armEncoder.getDistance());
  }

  @Override
  public void periodic() {
    log();
  }
}
