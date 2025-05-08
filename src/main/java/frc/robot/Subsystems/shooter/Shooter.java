package frc.robot.Subsystems.Shooter;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Subsystems.Shooter.ShooterIO.ShooterIOInputs;

public class Shooter extends SubsystemBase {

    private ShooterIO shooterIO;
    
    public Shooter(ShooterIO shooterIO) {
        this.shooterIO = shooterIO;
    }

    public ShooterIO getIO() {
        return shooterIO;
    }
    /*
    public ShooterIOInputsAutoLogged Shooterinputs = new ShooterIOInputsAutoLogged();
    
    
    public void periodic(){
        shooterIO.updateInputs(Shooterinputs);
        Logger.processInputs().processInputs("Shooter", Shooterinputs);
    }
    */
}
