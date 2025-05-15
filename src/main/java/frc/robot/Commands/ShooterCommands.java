package frc.robot.Commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Subsystems.shooter.Shooter;

public class ShooterCommands {
    public static Command setSetPointCommand(Shooter shoot, double setPoint){
        return Commands.run(() -> shoot.getIO().setSetPoint(setPoint), shoot).until(shoot.getIO().atSetPoint()).withName("setSetPointCommand: " + setPoint);
    }

    public static Command shootNote(Shooter shoot){
        return Commands.startEnd(() -> shoot.getIO().setVoltage(1), () -> shoot.getIO().stopMotor(), shoot);
    }

    public static Command stopMotor(Shooter shoot) {
        return Commands.run(() -> shoot.getIO().stopMotor());
    }
}