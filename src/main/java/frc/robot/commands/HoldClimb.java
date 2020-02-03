/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.subsystems.ClimbSubsystem;


public class HoldClimb extends WaitCommand {

  private final ClimbSubsystem m_climb;

  public HoldClimb(ClimbSubsystem climbSubsystem) {
    super(Constants.kTimeToHoldClimb);
    this.m_climb = climbSubsystem;
    addRequirements(m_climb);
  }

  @Override
  public void initialize() {
    this.m_climb.hold();
  }

  @Override
  public void end(boolean interrupted) {
    super.end(interrupted);
    this.m_climb.stop();
  }
}
