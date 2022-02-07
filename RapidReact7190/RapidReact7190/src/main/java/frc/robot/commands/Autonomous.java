package frc.robot.commands;


class Autonomous extends SequentialCommandGroup {
 public Autonomous(DriveSubsystem drive, HatchSubsystem hatch) {
    addCommands(
        new DriveDistance(
            AutoConstants.kAutoDriveDistanceInches, AutoConstants.kAutoDriveSpeed, drive),

        new ReleaseHatch(hatch),

        new DriveDistance(
            AutoConstants.kAutoBackupDistanceInches, -AutoConstants.kAutoDriveSpeed, drive));
  } 
}
