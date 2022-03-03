package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.LimeLightConstants;
import frc.robot.subsystems.Barrel;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class LimeLightShoot extends SequentialCommandGroup {

    public LimeLightShoot(DriveTrain driveTrain, Barrel barrel, Shooter shooter) {
        this.addRequirements(driveTrain);
        this.addCommands(
            new LimeLightRotate(driveTrain, LimeLightConstants.ROT_SETTINGS_ROUGH),
                new LimeLightMove(driveTrain, LimeLightConstants.MOVE_SETTINGS_DEFAULT),
                new LimeLightRotate(driveTrain, LimeLightConstants.ROT_SETTINGS_PRECISE),
            new ParallelRaceGroup(
                new RunSimpleSubsystem(shooter, false, 2),
                new DriveStop(driveTrain)
            ),
            new ParallelCommandGroup(
                new RunSimpleSubsystem(barrel, false, 4.0),
                new RunSimpleSubsystem(shooter, false, 4.0),
                new DriveStop(driveTrain)
            )
        );
    }
}
