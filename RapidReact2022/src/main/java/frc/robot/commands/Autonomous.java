package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Barrel;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class Autonomous extends SequentialCommandGroup {
  public Autonomous(DriveTrain driveTrain, Intake intake, Barrel barrel, Shooter shooter) {
    this.addRequirements(driveTrain);
    addCommands(
      // drive forward
      new DriveDuration(driveTrain, 0.3, 0.0, 0.0, 1.0),
      // intake and drive
      new ParallelCommandGroup(
          new RunSimpleSubsystem(intake, false, 2.0),
          new RunSimpleSubsystem(barrel, false, 2.0),
          new DriveDuration(driveTrain, .2, 0.0, 0.0, 1.0)),
      // barrel intake
      new ParallelRaceGroup(
          new RunSimpleSubsystem(barrel, false, 2.0),
          new DriveStop(driveTrain)
      ),
      // barrel adjust
      new ParallelRaceGroup(
          new RunSimpleSubsystem(barrel, true, .5),
          new DriveStop(driveTrain)
      ),
      // shoot
      new LimeLightShoot(driveTrain, barrel, shooter),
      new DriveStop(driveTrain)
    );
  }


}
