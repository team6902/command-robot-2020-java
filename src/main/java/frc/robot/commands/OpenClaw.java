/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

public class OpenClaw extends CommandBase {
  
  private final ClimbSubsystem m_climbSubsystem;

  public OpenClaw(ClimbSubsystem climbSubsystem) {
    addRequirements(climbSubsystem);
    m_climbSubsystem = climbSubsystem;
  }

  @Override
  public void initialize() {
    m_climbSubsystem.openClaw();
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
