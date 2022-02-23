package frc.robot.commands;

import java.util.HashMap;

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

    private boolean foundTarget = false;

    public float defaultSpeed;
    public float smallThreshold;
    public float smallSpeed;
    public float stopThreshold;


    public LimeLightMove(DriveTrain driveTrain, HashMap<String, Float> settings) {
        this.driveTrain = driveTrain;
        this.defaultSpeed = settings.get("default speed");
        this.smallThreshold = settings.get("small threshold");
        this.smallSpeed = settings.get("small speed");
        this.stopThreshold = settings.get("stop threshold");

        this.addRequirements(driveTrain);
        this.prevMoveValue = 0.0;
    }

    @Override
    public void execute() {
        float yOffset = (float) this.yOffsetEntry.getDouble(0.0);
        float moveValue;
        // offset is below threshold for moving at default speed
        if (Math.abs(yOffset) < this.smallThreshold) {
            if (yOffset < 0)
                moveValue = this.smallSpeed;
            else 
                moveValue = -this.smallSpeed;
            
        }
        // move at default speed
        else {
            if (yOffset < 0)
                moveValue = this.defaultSpeed;
            else 
                moveValue = -this.defaultSpeed;
            
        }

        // have we found target
        if (Math.abs(yOffset) < this.stopThreshold) {
            this.foundTarget = true;
        }
        this.driveTrain.move(moveValue, 0.0, 0.0);
            
    }
    @Override
    public boolean isFinished() {
        return this.foundTarget;
    }

    @Override
    public void end(boolean interupted) {
        this.foundTarget = false;
    }
    
}
