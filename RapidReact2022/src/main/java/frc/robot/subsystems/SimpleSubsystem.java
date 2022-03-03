package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


/**
* An interface that provides simple methods for every motor
* 
*/
public interface SimpleSubsystem {
    public void run();
    public void stop();
    public void reverse();
}
