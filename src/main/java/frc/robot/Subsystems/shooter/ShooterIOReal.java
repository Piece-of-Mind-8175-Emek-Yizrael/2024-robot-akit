package frc.robot.Subsystems.shooter;

import static frc.robot.Subsystems.shooter.ShooterConstants.LEFT_ID;
import static frc.robot.Subsystems.shooter.ShooterConstants.RIGHT_ID;

import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkMax;


public class ShooterIOReal implements ShooterIO {
    private final SparkMax leftMotor = new SparkMax(RIGHT_ID, MotorType.kBrushless);
    private final SparkMax rightMotor = new SparkMax(LEFT_ID, MotorType.kBrushless);

    @Override
    public void updateInputs(ShooterIOInputs inputs) {
        inputs.LeftVelocity = leftMotor.getEncoder().getVelocity();
        inputs.RightVelocity = rightMotor.getEncoder().getVelocity();
    }

    @Override
    public void setSpeed(double speed) {
        leftMotor.set(speed);
        rightMotor.set(speed);
    }

    @Override
    public void stopMotor() {
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }

}