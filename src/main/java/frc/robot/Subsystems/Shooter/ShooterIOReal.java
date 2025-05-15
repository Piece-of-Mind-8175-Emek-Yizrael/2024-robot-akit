package frc.robot.Subsystems.Shooter;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import java.util.function.BooleanSupplier;
import static frc.robot.Subsystems.Shooter.ShooterConstants.*;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;

public class ShooterIOReal implements ShooterIO {
     
        private final SparkMax right_motor;
        private final SparkMax left_motor;
        private final PIDController pidController;
        SparkMaxConfig config;
        RelativeEncoder encoder;
        
        public ShooterIOReal() {   
            right_motor = new SparkMax(RIGHT_MOTOR_ID, MotorType.kBrushless ); 
            left_motor = new SparkMax(LEFT_MOTOR_ID, MotorType.kBrushless );
            pidController = new PIDController(Kp, Ki, Kd);
            config = new SparkMaxConfig();
            encoder = right_motor.getEncoder();
            config
            .idleMode(IdleMode.kCoast).follow(right_motor, true).closedLoop.outputRange(-0.5, 0.5);
            pidController.setTolerance(TOLERANCE);
            
            
            
        }
        
        
        @Override
        public void setSpeed(double speed) {
            right_motor.set(speed);
        }
        
        @Override
        public void setVoltage(double voltage) {
            right_motor.setVoltage(MathUtil.clamp(voltage,  -8 , 8));
        }
    
        @Override
        public void stopMotor() {
            right_motor.stopMotor();
        }
        
        @Override
        public void setSetPoint(double goal) {
            pidController.setSetpoint(goal);
            setVoltage(pidController.calculate(encoder.getVelocity())*10);
        }

        @Override
        public BooleanSupplier atSetPoint() {
            return () -> pidController.atSetpoint();
        }

        @Override
        public double getRightVelocity(){
            return right_motor.getEncoder().getVelocity();
        }
        
        @Override
        public double getLeftVelocity(){
            return left_motor.getEncoder().getVelocity();
        }
        
}
