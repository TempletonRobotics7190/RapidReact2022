package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

class Autonomous extends SequentialCommandGroup {
 public Autonomous(DriveTrain drive) {
//     addCommands(
//         new DriveDistance(
//             AutoConstants.kAutoDriveDistanceInches, AutoConstants.kAutoDriveSpeed, drive),

//         new ReleaseHatch(hatch),

//         new DriveDistance(
//             AutoConstants.kAutoBackupDistanceInches, -AutoConstants.kAutoDriveSpeed, drive));
  } 
}
