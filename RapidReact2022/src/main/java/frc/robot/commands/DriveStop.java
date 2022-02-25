package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveStop extends CommandBase {
    private DriveTrain driveTrain;

    public DriveStop(DriveTrain driveTrain) {
        this.driveTrain = driveTrain;
        this.addRequirements(this.driveTrain);
    }
    @Override
    public void initialize() {
        this.driveTrain.move(0.0, 0.0, 0.0);
    }
}
