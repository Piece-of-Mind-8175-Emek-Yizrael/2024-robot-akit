package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Subsystems.Arm.Arm;
import frc.robot.Subsystems.Arm.ArmIO;

public class ArmCommands extends SubsystemBase {
    Arm arm;

    public Command runArm(double speed) {
        return Commands.runEnd(() -> arm.getIO().setSpeed(speed), () -> arm.getIO().stopMotor(), arm);
    }

    public Command runArmFF(double goal, double velocity) {
        return Commands.runEnd(() -> arm.getIO().setFF(goal, velocity), () -> arm.getIO().stopMotor(), arm);
    }

    public Command runArmPIDWithFF(double goal, double velocity) {
        return new FunctionalCommand(() -> {
        }, () -> arm.getIO().setPIDWIithFF(goal, velocity),
                Interrupted -> arm.getIO().stopMotor(), () -> arm.getIO().atGoal(), arm);

    }

}
