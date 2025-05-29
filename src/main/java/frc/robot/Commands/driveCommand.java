package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.drive.Drive;

public class driveCommand extends Command {

    Drive driveSubsystem;
    double leftMotorPrecent;
    double rightMotorPrecent;
    
    public driveCommand(Drive drive , double lEftMotorPrecent, double rIghtMotorPrecent){
        driveSubsystem = drive;
        leftMotorPrecent = lEftMotorPrecent;
        rightMotorPrecent= rIghtMotorPrecent;
    }

    @Override
    public void initialize() {
        driveSubsystem.setPrecentageToLeft(leftMotorPrecent);
        driveSubsystem.setPrecentageToRight(rightMotorPrecent);
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.stopMotors();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
