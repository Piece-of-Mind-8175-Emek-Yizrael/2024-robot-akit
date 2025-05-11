
package frc.robot.Subsystems.shooter_yanir;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shooterSubsystem extends SubsystemBase {
    static SparkMaxConfig config = new SparkMaxConfig();
    static SparkMax flyWheelMain = new SparkMax(5, MotorType.kBrushless);
    static SparkMax flyWheelFollow = new SparkMax(6, MotorType.kBrushless);
    static DigitalInput digitalInput = new DigitalInput(3);

    public shooterSubsystem() {
        config
                .idleMode(IdleMode.kCoast)
                .follow(flyWheelMain, false);

        flyWheelFollow.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void setSpeed(double speed) {
        flyWheelMain.set(speed);
    }

    public void setVoltage(double voltage){
        flyWheelMain.setVoltage(voltage);
    }
    public double getSpeed() {
        return flyWheelMain.get();
    }

    public boolean isRingIn() {
        return digitalInput.get();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("FlyWheels Speed", getSpeed());
        SmartDashboard.putBoolean("is Ring in", isRingIn());
    }

    public void stopMotor() {
        flyWheelMain.stopMotor();
    }
}