package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Constants.LimeLightConstants;
// import frc.robot.Constants.*;
import frc.robot.subsystems.DriveTrain;

public class LimeLightRotate extends CommandBase {
    private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private NetworkTableEntry xOffsetEntry = table.getEntry("tx");
    private NetworkTableEntry focused = table.getEntry("ty");

    private DriveTrain driveTrain;

    private double prevRotValue;

    public LimeLightRotate(DriveTrain driveTrain) {
        this.driveTrain = driveTrain;
        this.addRequirements(driveTrain);
        this.prevRotValue = 0.0;
    }

    @Override
    public void execute() {
        double focused = this.focused.getDouble(0.0);
        double xOffset = this.xOffsetEntry.getDouble(0.0);
        double rotValue = LimeLightConstants.ROT_BLIND_SPEED;

        if (focused == 0.0f)
        {
                // We don't see the target, seek for the target by spinning in place at a safe speed.
                this.driveTrain.move(0.0, 0.0, rotValue);
        }
        else
        {
                // We do see the target, execute aiming code
                rotValue = -LimeLightConstants.SHIFT_CONTR*xOffset;
                if (rotValue > LimeLightConstants.ROT_THRESHOLD) {
                    rotValue = LimeLightConstants.ROT_THRESHOLD;
                }
                else if (rotValue < -LimeLightConstants.ROT_THRESHOLD) {
                    rotValue = -LimeLightConstants.ROT_THRESHOLD;
                }

                this.driveTrain.move(0.0, 0.0, rotValue);

        }
        this.prevRotValue = rotValue;

        
        

    }

    @Override
    public boolean isFinished() {
        if (Math.abs(this.prevRotValue) < LimeLightConstants.ROT_THRESHOLD) {
            return true;
        }
        return false;
    }
}
