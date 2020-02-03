package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;


public class SetDistanceToObject extends PIDCommand {
  private final DriveSubsystem m_drivetrain;

  public SetDistanceToObject(double distance, DriveSubsystem drivetrain) {
    super(new PIDController(Constants.kInfraredP, Constants.kInfraredI, Constants.kInfraredD),
        drivetrain::getDistanceToObstacle, distance,
        d -> drivetrain.arcadeDrive(d, 0.0));

    m_drivetrain = drivetrain;
    addRequirements(m_drivetrain);

    getController().setTolerance(Constants.kInfraredPIDTolerance);
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
