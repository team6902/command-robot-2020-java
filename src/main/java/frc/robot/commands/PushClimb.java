/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.subsystems.ClimbSubsystem;

public class PushClimb extends WaitCommand {
  
  private final ClimbSubsystem m_climbSubsystem;

  // Not tested
  public PushClimb(ClimbSubsystem climbSubsystem) {
    super(Constants.kTimeToPushClimb);
    addRequirements(climbSubsystem);
    m_climbSubsystem = climbSubsystem;
  }

  @Override
  public void initialize() {
    m_climbSubsystem.up();
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    super.end(interrupted);
    m_climbSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return super.isFinished();
  }
}
