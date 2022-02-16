package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Autonomous;
import frc.robot.commands.DefaultDrive;
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
  private final XboxController controller = new XboxController(0);

  // subsystems
  private final DriveTrain driveTrain = new DriveTrain();
  private final Intake intake = new Intake();
  private final Shooter shooter = new Shooter();
  private final Barrel barrel = new Barrel();

  // commands
  private final LimeLightShoot limeLightShoot = new LimeLightShoot(driveTrain);
  private final DefaultDrive defaultDrive = new DefaultDrive(driveTrain, controller);


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

    yButton.whenHeld(new StartEndCommand(this.shooter::run, this.shooter::stop));
    xButton.whenHeld(new StartEndCommand(this.barrel::run, this.barrel::stop));

    // reverse controls = bumper left
    // boost speed = bumper right
    // rightBumper.whenHeld(this.defaultDrive::boost, this.defaultDrive::unBoost);
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
    return new Autonomous(driveTrain);
  }
}
