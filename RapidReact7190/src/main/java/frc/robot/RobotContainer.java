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

  // commands
  private final LimeLightRotate limeLightRotate = new LimeLightRotate(driveTrain);
  private final LimeLightMove limeLightMove = new LimeLightMove(driveTrain);
  private final DefaultDrive defaultDrive = new DefaultDrive(driveTrain, controller);

  // The robot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  // private final ExampleCommand m_autoCommand = new
  // ExampleCommand(m_exampleSubsystem);

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

    yButton.whenHeld(this.limeLightRotate);
    aButton.whenHeld(this.limeLightMove);
    bButton.whenHeld(new StartEndCommand(this.intake::run, this.intake::stop));
    xButton.whenHeld(new StartEndCommand(this.shooter::run, this.shooter::stop));
  }


  public Command getAutonomousCommand() {
    return new Autonomous(driveTrain);
  }
}
