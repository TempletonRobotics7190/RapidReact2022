package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

public class LimeLightShoot extends SequentialCommandGroup {

    LimeLightShoot(DriveTrain driveTrain) {
        this.addRequirements(driveTrain);
        this.addCommands(
            new LimeLightRotate(driveTrain),
            new LimeLightMove(driveTrain)
        );
    }
}
