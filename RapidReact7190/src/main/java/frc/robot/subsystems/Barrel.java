package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.BarrelConstants;

public class Barrel extends SubsystemBase {
    
    private PWMSparkMax motor = new PWMSparkMax(BarrelConstants.CONTROLLER);


    public void run() {
        motor.set(BarrelConstants.SPEED);
    }

    public void reverse() {
        motor.set(BarrelConstants.REVERSE_SPEED);
    }

    public void stop() {
        motor.set(0.0);
    }

}
