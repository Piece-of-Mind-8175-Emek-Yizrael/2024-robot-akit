package frc.robot.Subsystems.shooter;

import java.util.function.BooleanSupplier;

import org.littletonrobotics.junction.AutoLog;

import frc.lib.tuneables.TuneableBuilder;

public interface ShooterIO {
    @AutoLog
    public static class ShooterIOInputs {
        public double RightVelocity;
        public double LeftVelocity;
    }

    public default void updateInputs(ShooterIOInputs inputs) {}

    public default void setSpeed(double speed) {}
    public default void setVoltage(double voltage) {}
    public default void stopMotor() {}
    public default double getSpeed() {return 0;}
    public default void setSetPoint(double goal) {}
    public default BooleanSupplier atSetPoint() {return null;}
    

}
