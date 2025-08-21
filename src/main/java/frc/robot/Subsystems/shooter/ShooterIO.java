package frc.robot.Subsystems.shooter;

import org.littletonrobotics.junction.AutoLog;

public interface ShooterIO {
    @AutoLog
    public static class ShooterIOInputs {
        public double shooterVoltage;
        public boolean isNoteIn;
    }

    public default void updateInputs(ShooterIOInputs inputs) {}
    public default void setVoltage(double Voltage) {}
    public default void stopMotor() {}
    public default boolean isNoteIn() {
        return false;
    }
    public default double getMotorVoltage(){
        return 0.0;
    }



    
}
