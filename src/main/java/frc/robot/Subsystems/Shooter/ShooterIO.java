package frc.robot.Subsystems.Shooter;

public interface ShooterIO {

    public static class ShooterIOInputs {
        public double speed;
        public double voltage;
    }

    void updateInputs(ShooterIOInputs inputs);

    void setSpeed(double speed);

    void setVoltage(double voltage);

    void stopMotor();
    
}
