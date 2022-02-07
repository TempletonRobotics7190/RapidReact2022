package frc.robot.commands;


public class Drive extends CommandBase {
  private DriveTrain driveTrain;
  
  private double ySpeed;
  private double xSpeed;
  private double zRotation;
  
  
 public Drive(DriveTrain driveTrain, double ySpeed, double xSpeed, double zRotation) {
    this.driveTrain = driveTrain;
    this.ySpeed = ySpeedLamda;
    this.xSpeed = xSpeedLamda
    this.zRotation = zRotationLamda;
    this.addRequirements(this.driveTrain);
  }

  @Override
  public void execute() {
    this.driveTrain.move(this.ySpeed, this.xSpeed, this.zSpeed);
  }
}
