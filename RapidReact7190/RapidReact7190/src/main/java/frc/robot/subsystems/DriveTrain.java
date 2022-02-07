package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import static robot.Constants

public class DriveTrain extends SubsystemBase {
    // The positive Y axis points ahead, the positive X axis points right, and the positive Z axis points down.
    // Rotations follow the right-hand rule, so clockwise rotation around the Z axis is positive

    private TalonSRX frontLeft = new TalonSRX(DriveConstants.FRONT_LEFT_CONTROLLER);
    private TalonSRX backLeft = new TalonSRX(DriveConstants.BACK_LEFT_CONTROLLER);
    private TalonSRX frontRight = new TalonSRX(DriveConstants.FRONT_RIGHT_CONTROLLER);
    private TalonSRX backRight = new TalonSRX(DriveConstants.BACK_RIGHT_CONTROLLER);
   
    private MecanumDrive mechanumDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    
    
    public void move(double ySpeed, double xSpeed, double zRotation) {
        this.mechanumDrive.driveCartesian(ySpeed, xSpeed, zRotation);
    }
    
    
    
    

    
    

    
}
