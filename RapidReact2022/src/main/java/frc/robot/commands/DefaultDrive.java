package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Constants.DriveConstants;


public class DefaultDrive extends CommandBase {
  private DriveTrain driveTrain;
  private XboxController controller;
  
  
 public DefaultDrive(DriveTrain driveTrain, XboxController controller) {
    this.driveTrain = driveTrain;
    this.controller = controller;
    this.addRequirements(this.driveTrain);
  }


  @Override
  public void execute() {
    boolean isReversed = this.controller.getBumper(Hand.kLeft);
    boolean isBoosted = this.controller.getBumper(Hand.kRight);
    int reverse = 1;
    double speed = DriveConstants.NORMAL_MOVE_SPEED;
    if (isReversed) {
      reverse = -1;
    }

    if (isBoosted) {
      speed = DriveConstants.BOOST_MOVE_SPEED;
    }
    
    double moveY = this.controller.getX(Hand.kLeft)*speed*reverse; // left, right
    double moveX = this.controller.getY(Hand.kLeft)*speed*-reverse; // forward, backward
    double rotationZ = this.controller.getX(Hand.kRight)*reverse*DriveConstants.ROT_SPEED; // rotation
    this.driveTrain.move(moveX, moveY, rotationZ);
  }
  
}
