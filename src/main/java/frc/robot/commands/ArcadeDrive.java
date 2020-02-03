/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDrive extends CommandBase {
  private final DriveSubsystem m_drivetrain;
  private final DoubleSupplier m_xSpeed;
  private final DoubleSupplier m_zRotation;

  public ArcadeDrive(DoubleSupplier xSpeed, DoubleSupplier zRotation, DriveSubsystem drivetrain) {
    m_drivetrain = drivetrain;
    m_xSpeed = xSpeed;
    m_zRotation = zRotation;
    addRequirements(m_drivetrain);
  }

  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(m_xSpeed.getAsDouble(), m_zRotation.getAsDouble());
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    m_drivetrain.arcadeDrive(0, 0);
  }
}
