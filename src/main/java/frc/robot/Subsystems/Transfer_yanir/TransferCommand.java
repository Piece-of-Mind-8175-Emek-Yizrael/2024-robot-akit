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
    public void initialize(){
        transferSubsystem.SetMotorVoltage(Voltage);
    }

    @Override
    public void end(boolean interrupted) {
        transferSubsystem.stopMotor();
    }

    @Override
    public boolean isFinished() {
        if (transferSubsystem.isRingLoaded()) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return transferSubsystem.isRingLoaded();
        }
        return false;
    }
}
