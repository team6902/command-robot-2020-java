package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.util.*;


public class DriveTurnTo extends PIDCommand {
  private final DriveSubsystem m_drivetrain;

  public DriveTurnTo(double angle, double maxTurnSpeed, DriveSubsystem drivetrain) {
    super(new PIDController(Constants.kTurnP, Constants.kTurnI, Constants.kTurnD),
        drivetrain::getHeading,
        angle,
        turn -> drivetrain.arcadeDrive(0, 
            SpeedLimit.get(turn, maxTurnSpeed)));

    m_drivetrain = drivetrain;
    addRequirements(m_drivetrain);
    getController().enableContinuousInput(-180, 180);
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