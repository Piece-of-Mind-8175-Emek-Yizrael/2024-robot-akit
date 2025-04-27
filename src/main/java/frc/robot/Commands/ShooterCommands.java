package frc.robot.Commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Subsystems.shooter.Shooter;

public class ShooterCommands {
    public static Command setSpeed(Shooter shooter, double speed) {
        return Commands.runOnce(() -> {
            shooter.setSpeed(speed);
        }, shooter);
    }

    public static Command stopShooter(Shooter shooter) {
        return Commands.runOnce(() -> {
            shooter.stopMotor();
        }, shooter);
    }

    public static Command startEndShoot(Shooter shooter, double speed) {
        return Commands.startEnd(() -> shooter.setSpeed(speed), () -> shooter.stopMotor(), shooter);
    }


    
}
