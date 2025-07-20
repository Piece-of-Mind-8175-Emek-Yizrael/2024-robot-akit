package frc.robot.Subsystems.Arm;

import org.littletonrobotics.junction.AutoLog;

public interface ArmIO {

   @AutoLog

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

   public default void setPIDWIithFF(double goal) {
   }

   public default void setFF() {
   }

   public default void resetEncoderIfPressed() {
   }

   public default void stopMotor() {
   }

   public default boolean atGoal() {
      return false;
   }

   public default void resetPID() {
   }

   public default void setPIDvalues() {
   }

}
