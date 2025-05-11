package frc.robot.Subsystems.Transfer_yanir;

import edu.wpi.first.wpilibj2.command.Command;

public class TransferCommand extends Command {
    
    TransferSubsystem transferSubsystem;
    double Voltage;

    public TransferCommand(double voltage, TransferSubsystem tRansferSubsystem){
        transferSubsystem = tRansferSubsystem;
        Voltage = voltage;
    }

    @Override
    public void initialize() {
        if (transferSubsystem.isRingLoaded()) {
            transferSubsystem.SetMotorVoltage(Voltage);
        }    
    }

    @Override
    public void end(boolean interrupted) {
        transferSubsystem.stopMotor();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
