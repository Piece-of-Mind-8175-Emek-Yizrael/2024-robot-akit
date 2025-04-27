package frc.robot.Subsystems.shooter;

import org.littletonrobotics.junction.AutoLog;

public interface ShooterIO {
    @AutoLog
    public static record ShooterIORecord(double leftPower, double rightPower, double leftVelocity, double rightVelocity) {

    }


    public default void updateInputs(ShooterIORecord inputs) {}

    public default void setVoltage(double voltage) {}
    public default void setPower(double speed) {}

    public default void setVelocity(double speed) {}

}
