/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ClimbSubsystem;


public class Climb extends SequentialCommandGroup {

  private final ClimbSubsystem m_climb;

  public Climb(ClimbSubsystem climbSubsystem) {
    super();
    this.m_climb = climbSubsystem;
    addCommands(
      new PushClimb(m_climb),
      new HoldClimb(m_climb)
    );
    addRequirements(m_climb);
  }
}
