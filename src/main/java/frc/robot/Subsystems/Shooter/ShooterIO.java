package frc.robot.Subsystems.Shooter;

import java.util.function.BooleanSupplier;

public interface ShooterIO {

    public static class ShooterIOInputs {
        public double speed;
        public double voltage;
    }

    public default void updateInputs(ShooterIOInputs inputs){}

    public default void setSpeed(double speed){}

    public default void setVoltage(double voltage){}

    public default void stopMotor(){}

    public default void setSetPoint(double goal) {
    }

    public default double getRightVelocity(){return 0;}
    public default double getLeftVelocity(){return 0;}

    public default BooleanSupplier atSetPoint(){
        return () -> false;}

    
    
}
