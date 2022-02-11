package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.*;
import frc.robot.subsystems.DriveTrain;

public class LimeLightRotate extends CommandBase {
    private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private NetworkTableEntry xOffsetEntry = table.getEntry("tx");
    private DriveTrain driveTrain;

    public LimeLightRotate(DriveTrain driveTrain) {
        this.driveTrain = driveTrain;
        this.addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        double xOffset = this.xOffsetEntry.getDouble(0.01);
        this.driveTrain.move(0, 0, -LimeLightConstants.SHIFT_CONTR*xOffset);
        System.out.println(xOffset);
        

    }
}
