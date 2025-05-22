package frc.robot.Subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class driveIOReal implements driveIO{

    
    private final VictorSPX leftLeader = new VictorSPX(0);// TODO get id/port number
    private final TalonSRX leftFollower = new TalonSRX(0);// TODO get id/port number
    private final VictorSPX rightLeader = new VictorSPX(0);// TODO get id/port number
    private final TalonSRX rightFollower = new TalonSRX(0);// TODO get id/port number

    public driveIOReal(){
       // TalonSRXConfiguration config = new TalonSRXConfiguration();

        leftLeader.setInverted(true);
        rightLeader.setInverted(false);

        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader); 
    }

    @Override
    public void setPrecentageToLeft(double leftMotorPrecent) {
        leftLeader.set(ControlMode.PercentOutput, leftMotorPrecent);
    }

    @Override
    public void setPrecentageToRight(double rightMotorPrecent) {
        rightLeader.set(ControlMode.PercentOutput, rightMotorPrecent);
    }

    @Override
    public void stopMotors() {
        rightLeader.set(ControlMode.PercentOutput, 0);
        leftFollower.set(ControlMode.PercentOutput, 0);
    }
}
