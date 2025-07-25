package frc.robot.Subsystems.Drive;

public interface DriveIO {

    public static class DriveIOInputs {
        public double voltage;
        public double velocity;
        public double position;
    }

    public default void setSpeed(double rightSpeed, double leftSpeed) {
    }

    public default void setVoltage(double rightVoltage, double leftVoltage) {
    }

    public default void stopMotor() {
    }

    public default void updateInputs(DriveIOInputs inputs) {
    }

    public default void arcadeDrive() {
    }

    public default void tankDrive() {
    }

}