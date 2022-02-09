package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class LimeLightRotate extends CommandBase {
    private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private NetworkTableEntry area = table.getEntry("ta");
    private DriveTrain train;

    public LimeLightRotate(DriveTrain train) {
        this.train = train;
        this.addRequirements(train);
    }


    public void execute() {
        double a = area.getDouble(0.0);
        float Kp = -0.1f;  // Proportional control constant);

        this.train.move(0, 0, Kp*a);
        System.out.println(Kp*a);


    }
}
