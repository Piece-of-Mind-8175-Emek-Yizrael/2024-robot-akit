package frc.robot.Subsystems.shoot;

import java.util.function.BooleanSupplier;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import static frc.robot.Subsystems.shoot.ShootingConstants.*;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;

public class ShootSparkMax implements ShootIO{
    private SparkMax upperMotor = new SparkMax(0, MotorType.kBrushless);
    private SparkMax downMotor = new SparkMax(0, MotorType.kBrushless);
    private ProfiledPIDController pidController;

    public ShootSparkMax(){
        SparkMaxConfig config = new SparkMaxConfig();
        pidController = new ProfiledPIDController(KP,KI,KD,new TrapezoidProfile.Constraints(MAX_ACCELERATION,MAX_VALOCITY ));

        config.idleMode(IdleMode.kCoast).follow(upperMotor, true)
                .smartCurrentLimit(0)
                .voltageCompensation(0);
   
    }

    @Override
    public void stopMotor() {
        upperMotor.stopMotor();
    }

    @Override
    public void setSpeed(double speed) {
        upperMotor.set(speed);
    }

    @Override
    public void setVoltage(double voltage) {
        upperMotor.setVoltage(voltage);
    }

    @Override
    public double getSpeed() {
        return (upperMotor.getEncoder().getVelocity() + downMotor.getEncoder().getVelocity()) / 2;
    }

    @Override
    public void setGoal(double goal) {
        pidController.setGoal(goal);
        setVoltage(pidController.calculate(getSpeed()));
    }

    @Override
    public BooleanSupplier atGoal() {
        return () -> pidController.atGoal();   
    }

    @Override
    public void setPidValues() {
        
    }
    
}