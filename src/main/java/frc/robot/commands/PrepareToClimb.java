/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ClimbSubsystem;


public class PrepareToClimb extends SequentialCommandGroup {

  private final ClimbSubsystem m_climb;
  private final ArmSubsystem m_arm;

  public PrepareToClimb(ClimbSubsystem climbSubsystem, ArmSubsystem armSubsystem) {
    super();
    this.m_arm = armSubsystem;
    this.m_climb = climbSubsystem;
    addCommands(
      new SetArm(() -> Constants.kArmUnfoldedSetpoint, armSubsystem),
      new OpenClaw(climbSubsystem)
    );
    addRequirements(m_climb, m_arm);
  }
}
