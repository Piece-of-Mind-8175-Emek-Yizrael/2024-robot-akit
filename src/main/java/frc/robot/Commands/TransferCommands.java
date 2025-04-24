package frc.robot.Commands;

import static frc.robot.Subsystems.Transfer.TransferConstants.TRANSFER_MOTOR_SPEED;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Transfer.TransferConstants.*;
import frc.robot.Subsystems.Transfer.Transfer;

public class TransferCommands extends Command {
    public static Command Transfer(Transfer transfer) {
        return transfer.runEnd(() -> transfer.setSpeed(TRANSFER_MOTOR_SPEED), transfer::stopMotor);
    }
}
