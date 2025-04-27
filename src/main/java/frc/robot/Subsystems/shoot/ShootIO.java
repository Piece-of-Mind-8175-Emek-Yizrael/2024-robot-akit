package frc.robot.Subsystems.shoot;

import java.util.function.BooleanSupplier;

import org.littletonrobotics.junction.AutoLog;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

public interface ShootIO {
    @AutoLog
    public static class ShootIOInputs {
    
    }

    public default void stopMotor(){}
    public default void setSpeed(double speed){}
    public default void setVoltage(double voltage){}
    public default void setGoal(double goal){}
    public default BooleanSupplier atGoal() { return () -> false; }
    public default void setPidValues(){}
    public default double getSpeed(){ return 0; }
}
