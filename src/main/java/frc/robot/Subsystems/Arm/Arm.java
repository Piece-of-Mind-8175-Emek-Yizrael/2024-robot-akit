package frc.robot.Subsystems.Arm;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    ArmIO armIO;

    public Arm(ArmIO armIO) {
        this.armIO = armIO;
    }

    public ArmIO getIO() {
        return armIO;
    }

}
