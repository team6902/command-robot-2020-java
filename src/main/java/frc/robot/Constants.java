/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

public final class Constants {

    /* USB ports */
    public static final int kPilotStickPort = 0;
    public static final int kCopilotStickPort = 1;

    /* ROBORIO ports */
    public static final int kPWMDriveMotorLeftPort = 0;
    public static final int kPWMDriveMotorRightPort = 1;
    public static final int kPWMClimbPort = 2;
    public static final int kPWMIntakePort = 3;
    // public static final int kPWMPanelPortUp = 4;
    public static final int kPWMPanelPortRotation = 5;
    public static final int kPWMArmPort = 6;
    // public static final int kPneumaticShooterPortForward = 0;
    // public static final int kPneumaticShooterPortBackward = 1;
    public static final int kPneumaticClimbPortForward = 2;
    public static final int kPneumaticClimbPortBackward = 3;
    public static final int kDIOEncoderAPort = 0;
    public static final int kDIOEncoderBPort = 1;
    public static final Port kNavXPort = I2C.Port.kOnboard;

    /* MOTORS DIRECTIONS */
    // Use this constants to define whether some motor is in the wrong direction:
    public static final boolean kDriveLeftInverted = false;
    public static final boolean kDriveRightInverted = false;
    public static final boolean kIntakeMotorInverted = false;
    public static final boolean kControlPanelMotorInverted = false;
    public static final boolean kClimbMotorInverted = false;

    /* BUTTONS m_pilotStick */
    public static final int kTurn90degrees = 1;
    public static final int kEnableTurnPID = 2;
    public static final int kIntakeButton = 6;

    /* BUTTONS m_copilotStick */
    public static final int KShooterButton = 2;
    public static final int kEnableReverseClimbButton = 5;
    public static final int kEnableClimbButton = 6;
    public static final int kEnablePneumaticClimbButton = 8;
    public static final int KEnablePanelUpButton = 9;
    public static final int kEnablePanelRotationButton = 10;

    /* SPEEDS */
    public static final double kIntakeSpeed = 0.5;
    public static final double kPanelUpSpeed = 0.5;
    public static final double kPanelRotationSpeed = 1;
    public static final double kArmSpeed = 1;
    public static final double kClimbSpeed = 0.4;
    public static final double kClimbHoldSpeed = 0.2;
    public static final double kClimbReverseSpeed = -0.4;

    /* INFRARED PID */
    public static final int kAnalogInInfraredPort = 0;
    public static final double kHoldDistanceBottomPort = 1; 
    public static final double kHoldDistanceControlPanel = 1;
    public static final double kHoldDistanceAutonomous = 1; 
    public static final double kInfraredP = 7.0;
    public static final double kInfraredI = 0.018;
    public static final double kInfraredD = 1.5;
    public static final double kInfraredPIDTolerance = .05;

    /* TURN PID */
    public static final double kTurnP = .0045;
    public static final double kTurnI = .006;
    public static final double kTurnD = .0001;
    public static final double kTurnPIDTolerance = .05;

    /* TURN setpoints */
    public static final double[] turnSetpoints = {0, 90, 180, 270};

    /* ARM PID */    
    public static final double kArmP = .01;
    public static final double kArmI = .05;
    public static final double kArmD = .0;
    public static final double kArmPIDTolerance = .05;

    /* ARM setpoints */
    // ToDo: set setpoints
    public static final double kArmUnfoldedSetpoint = 1;
    public static final double kArmFoldedSetpoint = 0;
    public static final double kArmClosedShooterSetpoint = .5;
    public static final double kArmOpenShooterSetpoint = .8; 

    /* Encoder constants */
    public static final double kArmEncoderDistancePerPulse = 1./7.;

    /* Climb constants */
    public static final double kTimeToPushClimb = 5;
    public static final double kTimeToHoldClimb = 5;

}
