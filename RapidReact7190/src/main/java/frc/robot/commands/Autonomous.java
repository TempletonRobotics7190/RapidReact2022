package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

public class Autonomous extends SequentialCommandGroup {
 public Autonomous(DriveTrain driveTrain) {
    addCommands(
        new Drive(
          driveTrain, 0.0, 0.2, 0.0, 1.0
        ),
        new Drive(
          driveTrain, 0.0, -0.2, 0.0, 1.0
        ),
        new Drive(
          driveTrain, 0.0, 0.2, 0.0, 1.0
        ),
        new Drive(
          driveTrain, 0.0, 0.0, 0.0, 1.0
        )
    );
  }

}
