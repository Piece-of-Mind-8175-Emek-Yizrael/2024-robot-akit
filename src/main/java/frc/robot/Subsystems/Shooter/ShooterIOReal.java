package frc.robot.Subsystems.Shooter;
import com.revrobotics.spark.SparkMax;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.POM_lib.sensors.POMDigitalInput;

    public class ShooterIOReal implements ShooterIO {
        private final POMDigitalInput transferSensor = new POMDigitalInput(0);
        private final SparkMax motor;
    
        public ShooterIOReal() {
        motor = new SparkMax(0, MotorType.kBrushless ); 
    
        }
    
        @Override
        public void updateInputs(ShooterIOInputs inputs) {
            inputs.speed = motor.get();
            inputs.voltage = motor.getBusVoltage();
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
        public void stopMotor() {
            motor.stopMotor();
        }
    
}
