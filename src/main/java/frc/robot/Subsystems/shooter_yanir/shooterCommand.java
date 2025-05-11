package frc.robot.Subsystems.shooter_yanir;

import edu.wpi.first.wpilibj2.command.Command;

public class shooterCommand extends Command {
    private final shooterSubsystem shooterSubsystem;
    private double Speed;

    public shooterCommand(shooterSubsystem shooterSubsystem, double speed) {
        this.shooterSubsystem = shooterSubsystem;
        this.Speed = speed;
    }

    @Override
    public void initialize() {

        shooterSubsystem.setVoltage(Speed);
    }

    @Override
    public void execute() {

    }

    public void end() {
        shooterSubsystem.stopMotor();
    }

    @Override
    public boolean isFinished() {
        // if (!shooterSubsystem.isRingIn()) {
        // return true;
        // } else {
        // return false;
        // }
        return true;
    }

}
