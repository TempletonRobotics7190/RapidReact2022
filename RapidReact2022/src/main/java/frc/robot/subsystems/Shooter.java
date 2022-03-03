package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase implements SimpleSubsystem {

    private Spark bigMotor = new Spark(ShooterConstants.BIG_CONTROLLER);
    private Spark smallMotor = new Spark(ShooterConstants.SMALL_CONTROLLER);

    public void run() {
        bigMotor.set(ShooterConstants.BIG_WHEEL_SPEED);
        smallMotor.set(ShooterConstants.SMALL_WHEEL_SPEED);
    }

    public void reverse() {
        bigMotor.set(ShooterConstants.REVERSE_SPEED);
        smallMotor.set(ShooterConstants.REVERSE_SPEED);
    }

    public void stop() {
        bigMotor.set(0.0);
        smallMotor.set(0.0);
    }
    
}
