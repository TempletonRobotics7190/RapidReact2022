package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase implements SimpleSubsystem {

    private PWMSparkMax motor = new PWMSparkMax(IntakeConstants.CONTROLLER);


    public void run() {
        motor.set(IntakeConstants.SPEED);
    }

    public void reverse() {
        motor.set(IntakeConstants.REVERSE_SPEED);
    }

    public void stop() {
        motor.set(0.0);
    }

    
}
