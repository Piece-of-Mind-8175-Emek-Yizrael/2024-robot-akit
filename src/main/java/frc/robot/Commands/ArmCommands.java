package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Subsystems.Arm.Arm;
import frc.robot.Subsystems.Arm.ArmIO;
import frc.robot.Subsystems.Arm.ArmSparkMax;

public class ArmCommands extends SubsystemBase {
    Arm arm;

    public ArmCommands(Arm arm) {
        this.arm = arm;
    }

    public Command runArm(double speed) {
        return Commands.runEnd(() -> arm.getIO().setSpeed(speed), () -> arm.getIO().stopMotor(), arm)
                .withName("set speed");
    }

    public Command runArmFF() {
        return Commands.runEnd(() -> arm.getIO().setFF(), () -> arm.getIO().stopMotor(), arm).withName("FF");
    }

    public Command runArmPIDWithFF(double goal) {
        return new FunctionalCommand(() -> arm.getIO().resetPID(), () -> arm.getIO().setPIDWIithFF(goal),
                Interrupted -> arm.getIO().stopMotor(), () -> arm.getIO().atGoal(), arm).withName("PID with FF");

    }

    public Command armDownPIDWithFF() {
        return new FunctionalCommand(() -> arm.getIO().resetPID(), () -> arm.getIO().setPIDWIithFF(0),
                Interrupted -> arm.getIO().stopMotor(), () -> arm.getIO().atGoal(), arm).withName("PID with FF");

    }

}
