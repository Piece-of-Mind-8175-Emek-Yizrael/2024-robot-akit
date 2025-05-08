package frc.robot.Subsystems.shooter;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.logfields.LogFieldsTable;
import static frc.robot.Subsystems.shooter.ShooterConstants.*;


public class Shooter extends SubsystemBase {
    public final ShooterIO shooterIO;

    LogFieldsTable fieldsTable = new LogFieldsTable(getName());
    private PIDController shootingPidController = new PIDController(KP, KI, KD);
    // :(


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
        fieldsTable.recordOutput("Speed", shooterIO.getSpeed());

    }

}
