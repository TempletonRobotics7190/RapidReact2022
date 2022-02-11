package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.GenericHID.Hand;;


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
    boolean revButton = this.controller.getXButton();
    boolean fastButton = this.controller.getBumper(Hand.kRight);
    
    int reverse = 1;
    double speed = 0.43; // 43 is good
    if (revButton) {
      reverse = -1;
    }

    if (fastButton) {
      speed = 0.50;
    }
    double moveY = this.controller.getX(Hand.kLeft)*speed*reverse; // left, right
    double moveX = this.controller.getY(Hand.kLeft)*speed*-reverse; // forward, backward
    double rotationZ = this.controller.getX(Hand.kRight)*0.6*reverse; // rotation
    this.driveTrain.move(moveX, moveY, rotationZ);
    
    
  }
  
}
