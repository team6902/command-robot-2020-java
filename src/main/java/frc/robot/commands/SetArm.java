/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;


public class SetArm extends PIDCommand {
  private final ArmSubsystem m_arm;
  private final DoubleSupplier m_position;

  public SetArm(DoubleSupplier position, ArmSubsystem arm) {
    super(new PIDController(Constants.kArmP, Constants.kArmI, Constants.kArmD),
        arm::pidGet,
        position,
        output -> arm.set(output));

    m_arm = arm;
    m_position = position;
    addRequirements(m_arm);
    getController().setTolerance(Constants.kArmPIDTolerance);
  }

  @Override
  public void execute() {
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    m_arm.stop();
  }
}