
package frc.robot.Subsystems.GroundCollect_yanir;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.POM_lib.sensors.POMDigitalInput;

public class GroundCollectSubsystem extends SubsystemBase {

    static VictorSPX mainMotor;
    static VictorSPX secondryMotor;

    static double outputToMotors;

    public GroundCollectSubsystem(double OutputToMotors){
        mainMotor = new VictorSPX(11);
        secondryMotor = new VictorSPX(10    );
        secondryMotor.follow(mainMotor);
        outputToMotors = OutputToMotors;
    }


    public static void setPower(double voltage){
        mainMotor.set(VictorSPXControlMode.PercentOutput, voltage);
    }

    public static double getPowerPrestage(){
        return mainMotor.getMotorOutputPercent();
    }

    public static void stopMotors(){
        mainMotor.set(ControlMode.PercentOutput, 0);
    }



    @Override
    public void periodic() {
        SmartDashboard.putNumber("motorOutputPresntage", getPowerPrestage());
        
    }
    
    
}