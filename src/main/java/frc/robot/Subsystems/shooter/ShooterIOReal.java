package frc.robot.Subsystems.shooter;

import static frc.robot.Subsystems.shooter.ShooterConstants.LEFT_ID;
import static frc.robot.Subsystems.shooter.ShooterConstants.NoteSensorID;
import static frc.robot.Subsystems.shooter.ShooterConstants.RIGHT_ID;
import static frc.robot.Subsystems.shooter.ShooterConstants.kD;
import static frc.robot.Subsystems.shooter.ShooterConstants.kI;
import static frc.robot.Subsystems.shooter.ShooterConstants.kP;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;


public class ShooterIOReal implements ShooterIO {
    private final SparkMax leadMotor = new SparkMax(RIGHT_ID, MotorType.kBrushless);
    private final SparkMax leftMotor = new SparkMax(LEFT_ID, MotorType.kBrushless);
    DigitalInput NoteSensor = new DigitalInput(NoteSensorID);
    PIDController pidController;
    ShooterIOInputs inputs;
    SparkMaxConfig config;



    public ShooterIOReal() {
        inputs = new ShooterIOInputs();
        config = new SparkMaxConfig();
        config.inverted(true);
        config.follow(RIGHT_ID);
        leftMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
        pidController = new PIDController(kP,kI, kD);
    }

    @Override
    public void updateInputs(ShooterIOInputs inputs) {
        inputs.shooterVoltage = getMotorVoltage();
        inputs.isNoteIn = isNoteIn();
    }

    @Override
    public boolean isNoteIn() {
        return NoteSensor.get();
    }

    @Override
    public void setVoltage(double Voltage) {
        leadMotor.setVoltage(pidController.calculate(inputs.shooterVoltage, Voltage));
    }

    @Override
    public void stopMotor() {
        leadMotor.stopMotor();
    }

    @Override
    public double getMotorVoltage() {
        return leadMotor.getBusVoltage();
    }

}