package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.*;
import frc.robot.subsystems.DriveTrain;

public class LimeLightMove extends CommandBase {
    private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private NetworkTableEntry yOffsetEntry = table.getEntry("ty");
    private DriveTrain driveTrain;

    public LimeLightMove(DriveTrain driveTrain) {
        this.driveTrain = driveTrain;
        this.addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        double xOffset = this.yOffsetEntry.getDouble(0.0);
        this.driveTrain.move(LimeLightConstants.SHIFT_CONTR*xOffset, 0.0, 0.0);
        SmartDashboard.putNumber("LimeLightRotate", LimeLightConstants.SHIFT_CONTR*xOffset);
        

    }
}
