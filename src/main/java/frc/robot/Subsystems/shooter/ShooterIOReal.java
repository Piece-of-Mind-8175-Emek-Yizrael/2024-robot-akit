package frc.robot.Subsystems.shooter;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.PIDController;
import frc.lib.tuneables.TuneableBuilder;
import static frc.robot.Subsystems.shooter.ShooterConstants.*;

import java.util.function.BooleanSupplier;


public class ShooterIOReal implements ShooterIO {
    private final SparkMax leftMotor = new SparkMax(RIGHT_ID, MotorType.kBrushless);
    private final SparkMax rightMotor = new SparkMax(LEFT_ID, MotorType.kBrushless);
    private PIDController pidController;
    private double maxInput = 12;



    public ShooterIOReal() {
        SparkBaseConfig config = new SparkMaxConfig().inverted(true);
        leftMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        pidController = new PIDController(KP, KI, KD);
    }

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
    public void setVoltage(double voltage) {
        rightMotor.setVoltage(voltage);
    }

    @Override
    public void stopMotor() {
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }

    @Override
    public double getSpeed() {
        return (Math.abs(leftMotor.getEncoder().getVelocity()) + Math.abs(rightMotor.getEncoder().getVelocity())) / 2;
    }
    
    @Override
    public void setSetPoint(double goal) {
        pidController.setSetpoint(goal);
        setVoltage(pidController.calculate(getSpeed())*12);
    }

    @Override
    public BooleanSupplier atSetPoint() {
        return () -> pidController.atSetpoint();
    }
    
}