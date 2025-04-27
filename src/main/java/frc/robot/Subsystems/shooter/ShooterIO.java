package frc.robot.Subsystems.shooter;

import org.littletonrobotics.junction.AutoLog;

public interface ShooterIO {
    @AutoLog
    public static class ShooterIOInputs {
        public double RightVelocity;
        public double LeftVelocity;
    }

    public default void updateInputs(ShooterIOInputs inputs) {}

    public default void setSpeed(double speed) {}
    public default void stopMotor() {}
    
}
