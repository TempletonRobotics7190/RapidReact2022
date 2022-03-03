package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SimpleSubsystem;

public class RunSimpleSubsystem extends CommandBase {

    private SimpleSubsystem subsystem;
    private double seconds;
    private Timer timer;
    private boolean reverse;

    public RunSimpleSubsystem(SimpleSubsystem subsystem, boolean reverse, double seconds) {
        this.subsystem = subsystem;
        this.seconds = seconds;
        this.timer = new Timer();
        this.timer.start();
        this.reverse = reverse;
        
    }

    @Override
    public void initialize() {
        this.timer.reset();
    }
    
    @Override
    public void execute() {
        if (this.reverse) {
            this.subsystem.reverse();
        }
        else {
            this.subsystem.run();
        }
        

    }

    @Override
    public boolean isFinished() {
        return this.timer.get() > this.seconds;
    }

    @Override
    public void end(boolean shit) {
        this.subsystem.stop();
    }
    
}
