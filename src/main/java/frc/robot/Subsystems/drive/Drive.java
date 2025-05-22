package frc.robot.Subsystems.drive;
import java.util.logging.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class drive extends SubsystemBase {
    driveIOReal driveIo;

    public drive(){
        driveIo = new driveIOReal();
    }

    public  void setPrecentageToLeft(double precent){
        driveIo.setPrecentageToLeft(precent);
    }

    public  void setPrecentageToRight(double precent){
        driveIo.setPrecentageToRight(precent);
    }

    public void stopMotors(){
        driveIo.setPrecentageToLeft(0);
        driveIo.setPrecentageToRight(0);
    }

    @Override
    public void periodic() {
        // TODO add Logger to record inputs(motor speed)
    }

   
}