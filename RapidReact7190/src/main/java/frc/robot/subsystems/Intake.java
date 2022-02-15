package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {

    private Spark motor = new Spark(IntakeConstants.CONTROLLER);


    public void run() {
        motor.set(IntakeConstants.SPEED);
    }

    public void stop() {
        motor.set(0.0);
    }

    
}
