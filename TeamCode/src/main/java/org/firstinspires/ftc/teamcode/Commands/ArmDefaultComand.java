package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Pinza;

public class ArmDefaultComand extends CommandBase {
    Arm arm;
    GamepadEx gamepad2;
    Pinza pinza;


    public ArmDefaultComand(Arm arm, GamepadEx gamepad2, Pinza pinza){
        this.gamepad2 = gamepad2;
        this.arm = arm;
        this.pinza = pinza;


        addRequirements(arm);

    }

   

    @Override
    public void execute(){

        if (gamepad2.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER)>.9) {
            arm.setPower(1);
            //CommandScheduler.getInstance().schedule(new InstantCommand(pinza::dejar));

        }

        if (gamepad2.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER)<.5) {
            arm.setPower(0);
            //CommandScheduler.getInstance().schedule(new InstantCommand(pinza::bajo));

        }

        if (gamepad2.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)>.9){
            arm.setPower(-1);
            //CommandScheduler.getInstance().schedule(new InstantCommand(pinza::bajo));
        }
        if (gamepad2.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)>0){
            arm.setPower(0);
           // CommandScheduler.getInstance().schedule(new InstantCommand(pinza::bajo));
        }

    }

}
