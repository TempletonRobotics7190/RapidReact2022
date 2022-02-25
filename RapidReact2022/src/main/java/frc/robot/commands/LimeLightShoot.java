package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.LimeLightConstants;
import frc.robot.subsystems.DriveTrain;

public class LimeLightShoot extends SequentialCommandGroup {

    public LimeLightShoot(DriveTrain driveTrain) {
        this.addRequirements(driveTrain);
        this.addCommands(
            new LimeLightRotate(driveTrain, LimeLightConstants.ROT_SETTINGS_ROUGH),
            new LimeLightMove(driveTrain, LimeLightConstants.MOVE_SETTINGS_DEFAULT),
            new LimeLightRotate(driveTrain, LimeLightConstants.ROT_SETTINGS_PRECISE)
        );
    }
}
