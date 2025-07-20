package frc.robot.Subsystems.Arm;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    ArmIO armIO;

    public Arm(ArmIO armIO) {
        this.armIO = armIO;
    }

    public ArmIO getIO() {
        return armIO;
    }

    @Override
    public void periodic() {
        getIO().setPIDvalues();
        getIO().resetEncoderIfPressed();
        SmartDashboard.putString("CurremtCommand",
                getCurrentCommand() == null ? "None" : getCurrentCommand().getName());
        // Logger.processInputs("Arm", null);// need to fix autoLog
        // getIO().updateInputs(null);// need to fix autoLog
    }

}
