package frc.robot.Subsystems.GroundCollect_yanir;

import edu.wpi.first.wpilibj2.command.Command;

public class GroundCollectCommand extends Command {
    
    double motorOutput;
    GroundCollectSubsystem groundCollectSubsystem;

    
    public GroundCollectCommand(double motorOutputPrasntage, GroundCollectSubsystem groundCollectSubsystem){
        motorOutput = motorOutputPrasntage;
        this.groundCollectSubsystem = groundCollectSubsystem;

    }

    @Override
    public void initialize(){
        GroundCollectSubsystem.setPower(motorOutput);
    }

    @Override
    public void end(boolean interrupted) {
        GroundCollectSubsystem.stopMotors();
    }


}
