package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.LimeLightConstants;
import frc.robot.subsystems.DriveTrain;

public class LimeLightShoot extends SequentialCommandGroup {

    public LimeLightShoot(DriveTrain driveTrain) {
        this.addRequirements(driveTrain);
        LimeLightRotate rotatePrecise = new LimeLightRotate(driveTrain, LimeLightConstants.ROT_SETTINGS_PRECISE);
        LimeLightRotate rotateRough = new LimeLightRotate(driveTrain, LimeLightConstants.ROT_SETTINGS_ROUGH);
        LimeLightMove moveDefault = new LimeLightMove(driveTrain, LimeLightConstants.MOVE_SETTINGS_DEFAULT);

        this.addCommands(
            rotateRough,
            moveDefault,
            rotatePrecise
        );
    }
}
