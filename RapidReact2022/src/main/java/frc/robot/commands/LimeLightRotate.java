package frc.robot.commands;

import java.util.HashMap;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;



public class LimeLightRotate extends CommandBase {
    private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private NetworkTableEntry xOffsetEntry = table.getEntry("tx");
    private NetworkTableEntry focused = table.getEntry("ty");

    private DriveTrain driveTrain;

    private boolean foundTarget = false;

    public float blindSpeed;
    public float smallSpeed;
    public float stopThreshold;
    public float offsetFraction;
    public float smallThreshold;

    public LimeLightRotate(DriveTrain driveTrain, HashMap<String, Float> settings) {
        this.driveTrain = driveTrain;
        this.blindSpeed = settings.get("blind speed");
        this.smallSpeed = settings.get("small speed");
        this.stopThreshold = settings.get("stop threshold");
        this.offsetFraction = settings.get("offset fraction");
        this.smallThreshold = settings.get("small threshold");
        this.addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        float focused = (float) this.focused.getDouble(0.0);
        float xOffset = (float) this.xOffsetEntry.getDouble(0.0);
        double rotValue;

        if (focused == 0.0f)
        {
                // We don't see the target, seek for the target by spinning in place at a safe speed.
                rotValue = this.blindSpeed;
        }
        else
        {
            // offset is below threshold for moving at fractional speed
            if (Math.abs(xOffset) < this.smallThreshold) {
                if (xOffset < 0)
                    rotValue = this.smallSpeed;
                else 
                    rotValue = -this.smallSpeed;
            }
            // move at fractional speed
            else {
                rotValue = -this.offsetFraction*xOffset;
            }

            // have we found target
            if (Math.abs(xOffset) < this.stopThreshold) {
                this.foundTarget = true;
            }
                

        }
        this.driveTrain.move(0.0, 0.0, rotValue);


        

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
