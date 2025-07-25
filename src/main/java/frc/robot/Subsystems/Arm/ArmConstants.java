package frc.robot.Subsystems.Arm;

public class ArmConstants {
    public final static int MOTOR_ID = 3;
    public final static int LIMIT_SWITCH_CHANNEL = 1;

    public final static boolean IS_NORMALLY_OPEN = true;

    public final static double kP = 0.7;
    public final static double kI = 0;
    public final static double kD = 0;
    public final static double kA = 0;
    public final static double kS = 0.3;
    public final static double kV = 3.7;
    public final static double kG = 0.65;

    public final static double MAX_VOLTAGE = 0;
    public final static double MIN_VOLTAGE = 0;
    public static final int CURRENT_LIMIT = 40;
    public static final double VOLTAGE_COMPENSATION = 12;
    public static final double POSITION_CONVERSION_FACTOR = 0.25 /* gears */ * 2 * Math.PI/* rads */ / 50.0 /* versa */;
    public static final boolean INVERTED = true;
    public static final double MAX_ACCELERATION = 5.5;
    public static final double MAX_VELOCITY = 2;
    public static final double TOLERANCE = 0.035;
}
