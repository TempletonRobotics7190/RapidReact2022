package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.*;
import frc.robot.subsystems.DriveTrain;

public class LimeLightMove extends CommandBase {
    private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private NetworkTableEntry yOffsetEntry = table.getEntry("ty");
    private DriveTrain driveTrain;

    private double prevMoveValue;



    public LimeLightMove(DriveTrain driveTrain) {
        this.driveTrain = driveTrain;
        this.addRequirements(driveTrain);
        this.prevMoveValue = 0.0;
    }

    @Override
    public void execute() {
        double yOffset = this.yOffsetEntry.getDouble(0.0);
        double moveValue = LimeLightConstants.SHIFT_CONTR*yOffset;
        if (moveValue > 0.2) {
            moveValue = 0.2;
        }
        else if (moveValue < -0.2) {
            moveValue = -0.2;
        }
        
        this.driveTrain.move(moveValue, 0.0, 0.0);
        this.prevMoveValue = moveValue;

    }
    @Override
    public boolean isFinished() {
        if (this.prevMoveValue < 0.1) {
            return true;
        }
        return false;
    }
}
