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
    private NetworkTableEntry focused = table.getEntry("ty");

    private DriveTrain driveTrain;

    public LimeLightRotate(DriveTrain driveTrain) {
        this.driveTrain = driveTrain;
        this.addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        double focused = this.focused.getDouble(0.0);
        double tx = this.xOffsetEntry.getDouble(0.0);

        double steering_adjust = 0.0f;
        if (focused == 0.0f)
        {
                // We don't see the target, seek for the target by spinning in place at a safe speed.
                steering_adjust = 0.3f;
        }
        else
        {
                // We do see the target, execute aiming code
                // double heading_error = tx;
                steering_adjust = LimeLightConstants.SHIFT_CONTR * tx;
        }

        this.driveTrain.move(0.0, 0.0, steering_adjust);
        

    }
}
