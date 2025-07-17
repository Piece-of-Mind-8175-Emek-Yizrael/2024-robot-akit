package frc.robot.Subsystems.Arm;

public interface ArmIO {

   public static class ArmIOInputs {

      double voltage;
      double position;
      double velocity;
      boolean limitSwitch;

   }

   public default void updateInputs(ArmIOInputs inputs) {
   }

   public default void setSpeed(double speed) {
   }

   public default void setVoltage(double voltage) {
   }

   public default void setPIDWIithFF(double goal, double velocity) {
   }

   public default void setFF(double goal, double velocity) {
   }

   public default void resetEncoder() {
   }

   public default void stopMotor() {
   }

   public default boolean atGoal() {
      return false;
   }

}
