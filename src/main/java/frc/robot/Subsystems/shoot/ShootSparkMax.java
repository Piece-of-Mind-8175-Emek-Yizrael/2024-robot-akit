package frc.robot.Subsystems.shoot;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.POM_lib.Motors.POMMotor;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkMax;

public class ShootSparkMax implements ShootIO{
    private SparkMax upperMotor = new SparkMax(0, MotorType.kBrushless);
    private SparkMax downMotor = new SparkMax(0, MotorType.kBrushless);

    public ShootSparkMax(){
        SparkMaxConfig config = new SparkMaxConfig();

        config.idleMode(IdleMode.kBrake).follow(upperMotor, true)
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
    
}