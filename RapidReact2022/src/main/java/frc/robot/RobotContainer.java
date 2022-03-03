package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.LimeLightConstants;
import frc.robot.commands.Autonomous;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.FlushBalls;
import frc.robot.commands.LimeLightMove;
import frc.robot.commands.LimeLightRotate;
import frc.robot.commands.LimeLightShoot;
import frc.robot.subsystems.Barrel;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // controller
  public final XboxController controller = new XboxController(0);

  // subsystems
  public final DriveTrain driveTrain = new DriveTrain();
  public final Intake intake = new Intake();
  public final Shooter shooter = new Shooter();
  public final Barrel barrel = new Barrel();

  // commands
  public final LimeLightShoot limeLightShoot = new LimeLightShoot(driveTrain, barrel, shooter);
  public final LimeLightMove limeLightMove = new LimeLightMove(driveTrain, LimeLightConstants.MOVE_SETTINGS_DEFAULT);
  public final LimeLightRotate limelightRotate = new LimeLightRotate(driveTrain, LimeLightConstants.ROT_SETTINGS_PRECISE);

  public final FlushBalls flushBalls = new FlushBalls(this.shooter, this.barrel, this.intake);

  public final DefaultDrive defaultDrive = new DefaultDrive(driveTrain, controller);


  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureButtonBindings();

    this.driveTrain.setDefaultCommand(this.defaultDrive);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton aButton = new JoystickButton(this.controller, XboxController.Button.kA.value);
    JoystickButton bButton = new JoystickButton(this.controller, XboxController.Button.kB.value);
    JoystickButton xButton = new JoystickButton(this.controller, XboxController.Button.kX.value);
    JoystickButton yButton = new JoystickButton(this.controller, XboxController.Button.kY.value);
    JoystickButton leftBumper = new JoystickButton(this.controller, XboxController.Button.kBumperLeft.value);
    JoystickButton rightBumper = new JoystickButton(this.controller, XboxController.Button.kBumperRight.value);
    JoystickButton rightTrigger = new JoystickButton(this.controller, XboxController.Axis.kRightTrigger.value);
    JoystickButton leftTrigger = new JoystickButton(this.controller, XboxController.Axis.kLeftTrigger.value);

    bButton.whenHeld(new StartEndCommand(this.intake::run, this.intake::stop));
    yButton.whenHeld(new StartEndCommand(this.barrel::run, this.barrel::stop));
    aButton.whileActiveOnce(this.flushBalls);
    xButton.whileHeld(new StartEndCommand(this.shooter::run, this.shooter::stop));
    

    // aButton.whenHeld(this.flushBalls);

    // leftBumper.whileActiveOnce(this.limeLightRotate);
    // rightBumper.whileActiveOnce(this.limeLightMove);

    // rightTrigger.whileActiveOnce(this.limeLightShoot);
    // reverse controls = bumper left
    // boost speed = bumper right
    // aim and shoot = hold right trigger (if let go, cancel operation)
    // rightTrigger.whileActiveOnce(this.limeLightShoot);
    // quick shoot =
    // intake = a
    // aButton.whenHeld(new StartEndCommand(this.intake::run, this.intake::stop));
    // magazine = x
    // xButton.whenHeld(new StartEndCommand(this.barrel::run, this.barrel::stop));
    // 
  }


  public Command getAutonomousCommand() {
    return new Autonomous(this.driveTrain, this.intake, this.barrel, this.shooter);
  }
}
