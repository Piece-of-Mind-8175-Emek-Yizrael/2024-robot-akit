package frc.robot.Subsystems.Drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {

    public DriveIO driveIO;

    public Drive(DriveIO driveIO) {
        this.driveIO = driveIO;
    }

    @Override
    public void periodic() {

    }

}
