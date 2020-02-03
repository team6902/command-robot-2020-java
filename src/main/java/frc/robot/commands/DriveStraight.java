package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.util.*;


public class DriveStraight extends PIDCommand {
  private final DriveSubsystem m_drivetrain;

  public DriveStraight(double angle, double speed, double maxSpeed, double maxTurnSpeed, DriveSubsystem drivetrain) {
    super(new PIDController(Constants.kTurnP, Constants.kTurnI, Constants.kTurnD),
        drivetrain::getHeading,
        angle,
        turn -> drivetrain.arcadeDrive(SpeedLimit.get(speed, maxSpeed),
            SpeedLimit.get(turn, maxTurnSpeed)));

    m_drivetrain = drivetrain;
    addRequirements(m_drivetrain);

    getController().setTolerance(Constants.kTurnPIDTolerance);
  }

  @Override
  public void initialize() {
    m_drivetrain.reset();
    super.initialize();
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}