package frc.robot.commands;


public class DefaultDrive extends CommandBase {
  private DriveTrain driveTrain;
  
  private DoubleSupplier ySpeedLamda;
  private DoubleSupplier xSpeedLamda;
  private DoubleSupplier zRotationLamda;
  
  
 public DefaultDrive(DriveTrain subsystem, DoubleSupplier ySpeedLamda, DoubleSupplier xSpeedLamda, DoubleSupplier zRotationLamda) {
    this.driveTrain = subsystem;
    this.ySpeedLamda = ySpeedLamda;
    this.xSpeedLamda = xSpeedLamda
    this.zRotationLamda = zRotationLamda;
    this.addRequirements(this.driveTrain);
  }

  @Override
  public void execute() {
    this.driveTrain.move(this.ySpeedLamda.getAsDouble(), this.xSpeedLamda.getAsDouble(), this.zSpeedLamda.getAsDouble());
  }
  
}
