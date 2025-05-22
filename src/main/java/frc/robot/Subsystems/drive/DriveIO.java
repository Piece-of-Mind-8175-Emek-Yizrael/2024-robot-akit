package frc.robot.Subsystems.drive;

public interface driveIO {

    public static class driveIOInputs {
    }

    public default void setPrecentageToRight(double rightPrecentegOutput){
    }

    public default void setPrecentageToLeft(double leftPrecentegOutput){
    }
    
    // stop the motors upon call
    public default void stopMotors(){
    }


}
