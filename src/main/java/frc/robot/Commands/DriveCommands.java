package frc.robot.Commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Subsystems.Drive.Drive;

public class DriveCommands extends Command {

    Drive drive;

    public DriveCommands(Drive drive) {
        this.drive = drive;
    }

}
