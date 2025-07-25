package frc.robot.Subsystems.Arm;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.ArmCommands;

public class Arm extends SubsystemBase {
    private final ArmIO armIO;
    private final ArmCommands armCommands = new ArmCommands(this);
    private final ArmIOInputsAutoLogged armInputs = new ArmIOInputsAutoLogged();

    public Arm(ArmIO armIO) {
        this.armIO = armIO;
        setDefaultCommand(armCommands.runArmFF());
    }

    public ArmIO getIO() {
        return armIO;
    }

    @Override
    public void periodic() {
        SmartDashboard.putString("CurremtCommand",
                getCurrentCommand() == null ? "None" : getCurrentCommand().getName());
        Logger.processInputs("Arm", armInputs);// need to fix autoLog
        getIO().updateInputs(armInputs);// need to fix autoLog
    }

}
