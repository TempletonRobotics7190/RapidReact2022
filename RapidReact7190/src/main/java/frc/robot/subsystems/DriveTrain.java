package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.VelocityMeasPeriod;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.SensorVelocityMeasPeriod;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.Constants.DriveConstants;

public class DriveTrain extends SubsystemBase {
    // The positive Y axis points ahead, the positive X axis points right, and the positive Z axis points down.
    // Rotations follow the right-hand rule, so clockwise rotation around the Z axis is positive

    private WPI_TalonSRX frontLeft = new WPI_TalonSRX(DriveConstants.FRONT_LEFT_CONTROLLER);
    private WPI_TalonSRX backLeft = new WPI_TalonSRX(DriveConstants.BACK_LEFT_CONTROLLER);
    private WPI_TalonSRX frontRight = new WPI_TalonSRX(DriveConstants.FRONT_RIGHT_CONTROLLER);
    private WPI_TalonSRX backRight = new WPI_TalonSRX(DriveConstants.BACK_RIGHT_CONTROLLER);
   
    private MecanumDrive mechanumDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    
    
    public void move(double ySpeed, double xSpeed, double zRotation) {
        this.mechanumDrive.driveCartesian(ySpeed, xSpeed, zRotation);
        if (Math.abs(xSpeed) + Math.abs(ySpeed) + Math.abs(zRotation) < 0.08) {
            this.frontLeft.set(0.05);
            this.backLeft.set(0.05);
            this.frontRight.set(-0.05);
            this.backRight.set(-0.05);
          }
        // frontLeft.configVelocityMeasurementWindow(1);
        // frontLeft.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_1Ms);

        double velPer100ms = this.frontLeft.getSelectedSensorVelocity(0)/4096;
        System.out.println(velPer100ms);
    }
    
    
    
    

    
    

    
}
