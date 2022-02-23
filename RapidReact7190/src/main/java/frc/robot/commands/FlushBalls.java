package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Barrel;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class FlushBalls extends CommandBase {

    private Shooter shooter;
    private Barrel barrel;
    private Intake intake;

    public FlushBalls(Shooter shooter, Barrel barrel, Intake intake) {
        this.shooter = shooter;
        this.barrel = barrel;
        this.intake = intake;
        this.addRequirements(shooter);
        this.addRequirements(barrel);
        this.addRequirements(intake);
    }

    @Override
    public void execute() {
        this.shooter.reverse();
        this.barrel.reverse();
    }

    @Override
    public void end(boolean interupted) {
        this.shooter.stop();
        this.barrel.stop();
    }
    
}
