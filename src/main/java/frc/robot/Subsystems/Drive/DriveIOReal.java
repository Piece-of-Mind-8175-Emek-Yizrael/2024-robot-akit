package frc.robot.Subsystems.Drive;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class DriveIOReal implements DriveIO {

    public TalonFX rightLeader;
    public VictorSPX rightFollower;
    public TalonFX LeftLeader;
    public VictorSPX leftFollower;
    TalonFXConfiguration configuration;
    DifferentialDrive differentialDrive;

    public DriveIOReal() {
        rightFollower = new VictorSPX(0);
        rightLeader = new TalonFX(0);
        leftFollower = new VictorSPX(0);
        LeftLeader = new TalonFX(0);
        differentialDrive = new DifferentialDrive(null, null);

        // leftFollower.follow(LeftLeader);
        // rightFollower.follow(rightLeader);

    }

    @Override
    public void setSpeed(double rightSpeed, double leftSpeed) {
        LeftLeader.set(leftSpeed);
        rightLeader.set(rightSpeed);
    }

    @Override
    public void setVoltage(double rightVoltage, double leftVoltage) {
        rightLeader.setVoltage(rightVoltage * 12);
        LeftLeader.setVoltage(leftVoltage);

    }

    @Override
    public void arcadeDrive() {

    }

}
