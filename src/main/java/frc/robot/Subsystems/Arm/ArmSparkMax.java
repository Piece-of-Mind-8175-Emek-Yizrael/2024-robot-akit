package frc.robot.Subsystems.Arm;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.POM_lib.sensors.POMDigitalInput;
import static frc.robot.Subsystems.Arm.ArmConstants.*;

public class ArmSparkMax implements ArmIO {

    SparkMax motor;
    ProfiledPIDController pidController;
    ArmFeedforward feedforward;
    POMDigitalInput limitSwitch;
    SparkBaseConfig config;
    RelativeEncoder encoder;

    public ArmSparkMax() {
        motor = new SparkMax(MOTOR_ID, MotorType.kBrushless);
        pidController = new ProfiledPIDController(kP, kI, kD, null);
        feedforward = new ArmFeedforward(kS, kG, kV, kA);
        limitSwitch = new POMDigitalInput(LIMIT_SWITCH_CHANNEL, IS_NORMALLY_OPEN);
        config = new SparkMaxConfig();
        encoder = motor.getEncoder();

        config.idleMode(IdleMode.kCoast).inverted(INVERTED)
                .smartCurrentLimit(CURRENT_LIMIT)
                .voltageCompensation(VOLTAGE_COMPENSATION);

        config.encoder.positionConversionFactor(1.0)
                .velocityConversionFactor(1.0 / 60.0);

        motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        encoder.setPosition(0);

        pidController.setTolerance(TOLERANCE);

    }

    @Override
    public void updateInputs(ArmIOInputs inputs) {
        inputs.voltage = motor.getBusVoltage() * motor.getAppliedOutput();
        inputs.limitSwitch = limitSwitch.get();
        inputs.position = encoder.getPosition();
        inputs.velocity = encoder.getVelocity();
    }

    @Override
    public void setSpeed(double speed) {
        motor.set(speed);
    }

    @Override
    public void setVoltage(double voltage) {
        motor.setVoltage(voltage);
    }

    @Override
    public void setFF() {

    }

}
