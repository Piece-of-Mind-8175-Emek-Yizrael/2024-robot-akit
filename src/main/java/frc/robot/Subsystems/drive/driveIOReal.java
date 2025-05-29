package frc.robot.Subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class driveIOReal implements DriveIO{

    
    private final VictorSPX leftLeader = new VictorSPX(2);
    private final TalonSRX leftFollower = new TalonSRX(1);
    private final VictorSPX rightLeader = new VictorSPX(4);
    private final TalonSRX rightFollower = new TalonSRX(3);

    public driveIOReal(){
       // TalonSRXConfiguration config = new TalonSRXConfiguration();

        leftLeader.setInverted(true);
        rightLeader.setInverted(false);

        leftFollower.follow(leftLeader);
        leftFollower.setInverted(true);
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
