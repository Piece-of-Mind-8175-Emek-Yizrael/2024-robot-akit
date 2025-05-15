package frc.robot.Subsystems.Transfer_yanir;

import com.ctre.phoenix6.signals.InvertedValue;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.POM_lib.sensors.POMDigitalInput;

public class TransferSubsystem extends SubsystemBase {
    
    static SparkMax transferMotor;
    static POMDigitalInput digitalInput;
    
    public TransferSubsystem(){
        transferMotor = new SparkMax(8, MotorType.kBrushless);
        digitalInput = new POMDigitalInput(0);
    }

    public void SetMotorVoltage(double voltage){
        transferMotor.setVoltage(-voltage);
    }

    public void stopMotor(){
        transferMotor.setVoltage(0);
    }

    public double getVoltage(){
        return transferMotor.getBusVoltage();
    }

    public boolean isRingLoaded(){
        return digitalInput.get();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("transferMotor voltage", getVoltage());
    }



}
