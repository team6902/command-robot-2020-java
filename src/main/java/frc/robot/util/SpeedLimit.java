/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.util;

public class SpeedLimit {

    public static double get(double speed, double limit) {
        if (speed > limit)
            return limit;
        if (speed < -limit)
            return -limit;
        return speed;
    }

}
