package frc.robot.Subsystems.shooter;

import static frc.robot.Subsystems.shooter.ShooterConstants.LEFT_ID;
import static frc.robot.Subsystems.shooter.ShooterConstants.RIGHT_ID;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ShooterIOReal implements ShooterIO {
    private final CANSparkMax leftMotor = new CANSparkMax(LEFT_ID, MotorType.kBrushless);
    private final CANSparkMax rightMotor = new CANSparkMax(RIGHT_ID, MotorType.kBrushless);

    public ShooterIOReal() {
        // Configure motors
        leftMotor.setInverted(false);
        rightMotor.setInverted(true);
    }

    @Override
    public void setSpeed(double speed) {
        leftMotor.set(speed);
        rightMotor.set(speed);
    }

    @Override
    public void stop() {
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }

    @Override
    public double getLeftMotorSpeed() {
        return leftMotor.get();
    }

    @Override
    public double getRightMotorSpeed() {
        return rightMotor.get();
    }

    @Override
    public void setVoltage(double voltage) {
        leftMotor.setVoltage(voltage);
        rightMotor.setVoltage(voltage);
    }

    @Override
    public boolean isAtTargetSpeed(double targetSpeed) {
        double leftSpeed = leftMotor.getEncoder().getVelocity();
        double rightSpeed = rightMotor.getEncoder().getVelocity();
        return Math.abs(leftSpeed - targetSpeed) < 50 && Math.abs(rightSpeed - targetSpeed) < 50;
    }
}
