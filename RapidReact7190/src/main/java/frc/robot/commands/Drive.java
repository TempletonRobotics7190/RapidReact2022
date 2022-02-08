package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase {
  private DriveTrain driveTrain;
  
  private double ySpeed;
  private double xSpeed;
  private double zRotation;
  private Timer timer;
  private double duration;
  
  
  public Drive(DriveTrain driveTrain, double ySpeed, double xSpeed, double zRotation, double duration) {
    this.driveTrain = driveTrain;
    this.ySpeed = ySpeed;
    this.xSpeed = xSpeed;
    this.zRotation = zRotation;
    this.timer = new Timer();
    this.duration = duration;
    this.addRequirements(this.driveTrain);
  }

  @Override
  public void execute() {
    this.driveTrain.move(this.ySpeed, this.xSpeed, this.zRotation);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
