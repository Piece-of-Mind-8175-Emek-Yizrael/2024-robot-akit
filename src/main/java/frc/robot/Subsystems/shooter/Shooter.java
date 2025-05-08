package frc.robot.Subsystems.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.logfields.LogFieldsTable;


public class Shooter extends SubsystemBase {
    public final ShooterIO shooterIO;

    LogFieldsTable fieldsTable = new LogFieldsTable(getName());

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
        fieldsTable.recordOutput("Left Speed", shooterIO.getLeftSpeed());
        fieldsTable.recordOutput("Right Speed", shooterIO.getRightSpeed());
    }

}
