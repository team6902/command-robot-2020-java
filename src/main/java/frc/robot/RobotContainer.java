/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.Map;
import static java.util.Map.entry;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.DefaultAutonomous;
import frc.robot.commands.DriveTurnTo;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SelectCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

// ToDO: add smartdashboard button to stop compressor

public class RobotContainer {
  private final Compressor compressor = new Compressor();
  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final ShooterSubsystem m_shooter = new ShooterSubsystem();
  private final ArmSubsystem m_arm = new ArmSubsystem();
  private final Joystick m_pilotStick = new Joystick(Constants.kPilotStickPort);
  // private final Joystick m_pilotStickAux = new Joystick(Constants.kPilotStickPort);
  private final Joystick m_copilotStick = new Joystick(Constants.kCopilotStickPort);

  public RobotContainer() {
    compressor.start();
    configureButtonBindings();
    setupDefaultCommands();
  }

  private enum CommandSelector {
    ONE, TWO, THREE
  }

  private CommandSelector select() {
    return CommandSelector.ONE;
  }

  private final Command m_autoSelectCommand =
      new SelectCommand(
          // ToDo: change PrintCommand to AutonomousCommand
          Map.ofEntries(
              entry(CommandSelector.ONE, new DefaultAutonomous(m_drive, m_arm)),
              entry(CommandSelector.TWO, new PrintCommand("Command two was selected!")),
              entry(CommandSelector.THREE, new PrintCommand("Command three was selected!"))
          ),
          this::select
      );

  private void setupDefaultCommands() {
    m_drive.setDefaultCommand(new ArcadeDrive(() -> m_pilotStick.getY(Hand.kLeft),
        () -> m_pilotStick.getX(Hand.kRight), m_drive));
  }

  private void configureButtonBindings() {
    // ToDo: remove unused buttons
    final JoystickButton aPilotButton = new JoystickButton(m_pilotStick, 1);
    final JoystickButton bPilotButton = new JoystickButton(m_pilotStick, 2);
    final JoystickButton cPilotButton = new JoystickButton(m_pilotStick, 3);
    final JoystickButton dPilotButton = new JoystickButton(m_pilotStick, 4);
    final JoystickButton pilotdpadUp = new JoystickButton(m_pilotStick, 5);
    final JoystickButton pilotdpadRight = new JoystickButton(m_pilotStick, 6);
    final JoystickButton pilotdpadDown = new JoystickButton(m_pilotStick, 7);
    final JoystickButton pilotdpadLeft = new JoystickButton(m_pilotStick, 8);
    final JoystickButton lPilot2 = new JoystickButton(m_pilotStick, 9);
    final JoystickButton rPilot2 = new JoystickButton(m_pilotStick, 10);
    final JoystickButton lPilot1 = new JoystickButton(m_pilotStick, 11);
    final JoystickButton rPilot1 = new JoystickButton(m_pilotStick, 12);

    final JoystickButton aCopilotButton = new JoystickButton(m_copilotStick, 1);
    final JoystickButton bCopilotButton = new JoystickButton(m_copilotStick, 2);
    final JoystickButton cCopilotButton = new JoystickButton(m_copilotStick, 3);
    final JoystickButton dCopilotButton = new JoystickButton(m_copilotStick, 4);
    final JoystickButton copilotdpadUp = new JoystickButton(m_copilotStick, 5);
    final JoystickButton copilotdpadRight = new JoystickButton(m_copilotStick, 6);
    final JoystickButton copilotdpadDown = new JoystickButton(m_copilotStick, 7);
    final JoystickButton copilotdpadLeft = new JoystickButton(m_copilotStick, 8);
    final JoystickButton lCopilot2 = new JoystickButton(m_copilotStick, 9);
    final JoystickButton rCopilot2 = new JoystickButton(m_copilotStick, 10);
    final JoystickButton lCopilot1 = new JoystickButton(m_copilotStick, 11);
    final JoystickButton rCopilot1 = new JoystickButton(m_copilotStick, 12);

    bPilotButton.whenHeld(new DriveTurnTo(m_drive.getHeading() + 90,
        1.0, m_drive));

    // dpadUp.whenPressed(new SetElevatorSetpoint(0.2, m_elevator));
    // dpadDown.whenPressed(new SetElevatorSetpoint(-0.2, m_elevator));
    // dpadRight.whenPressed(new CloseClaw(m_claw));
    // dpadLeft.whenPressed(new OpenClaw(m_claw));

    // r1.whenPressed(new PrepareToPickup(m_claw, m_wrist, m_elevator));
    // r2.whenPressed(new Pickup(m_claw, m_wrist, m_elevator));
    // l1.whenPressed(new Place(m_claw, m_wrist, m_elevator));
    // l2.whenPressed(new Autonomous(m_drive, m_claw, m_wrist, m_elevator));
  }

  public Command getAutonomousCommand() {
    return m_autoSelectCommand;
  }
}
