package frc.robot.Subsystems.shooter;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Subsystems.shooter.ShooterIO.ShooterIOInputs;


public class Shooter extends SubsystemBase {
    public final ShooterIO shooterIO;
    public final ShooterIOInputs inputs = new ShooterIO.ShooterIOInputs();

    public Shooter(ShooterIO shooterIO) {
        this.shooterIO = shooterIO;
    }

    public void setSpeed(double speed) {
        shooterIO.setSpeed(speed);
    }

    public void stopMotor() {
        shooterIO.stopMotor();
    }

    @Override
    public void periodic() {
        shooterIO.updateInputs(inputs);
        //Logger.processInputs("Shooter", inputs);
    }

}
