package frc.robot.Subsystems.Drive;

import static frc.robot.Subsystems.Drive.DriveConstants.leftFollowerCanId;
import static frc.robot.Subsystems.Drive.DriveConstants.leftLeaderCanId;
import static frc.robot.Subsystems.Drive.DriveConstants.rightFollowerCanId;
import static frc.robot.Subsystems.Drive.DriveConstants.rightLeaderCanId;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFXS;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class DriveIOReal implements DriveIO {

    public TalonFXS rightLeader;
    public VictorSPX rightFollower;
    public TalonFXS LeftLeader;
    public VictorSPX leftFollower;
    TalonFXConfiguration configuration;
    DifferentialDrive differentialDrive;

    public DriveIOReal() {
        rightFollower = new VictorSPX(rightFollowerCanId);
        rightLeader = new TalonFXS(rightLeaderCanId);
        leftFollower = new VictorSPX(leftFollowerCanId);
        LeftLeader = new TalonFXS(leftLeaderCanId);
        // differentialDrive = new DifferentialDrive(null, null)

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
    public void stopMotor() {
        rightLeader.stopMotor();
        LeftLeader.stopMotor();
    }

    @Override
    public void arcadeDrive() {

    }

}
