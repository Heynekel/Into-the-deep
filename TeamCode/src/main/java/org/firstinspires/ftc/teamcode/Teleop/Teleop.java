package org.firstinspires.ftc.teamcode.Teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.ArmDefaultComand;
import org.firstinspires.ftc.teamcode.Commands.TankDriveComand;
import org.firstinspires.ftc.teamcode.Drive.SampleTankDrive;
import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Pinza;
import org.firstinspires.ftc.teamcode.Subsystems.TankDriveSubsystem;
@TeleOp


public class Teleop extends CommandOpMode {
    @Override
    public void initialize() {
        Pinza pinza = new Pinza(hardwareMap, telemetry);
        Arm arm = new Arm(hardwareMap, telemetry);
        GamepadEx gamepadDriver = new GamepadEx(gamepad1);
        GamepadEx gamepadsubsystems =  new GamepadEx(gamepad2);
        SampleTankDrive sampleTankDrive = new SampleTankDrive(hardwareMap);
        TankDriveSubsystem driveSubsystem =  new TankDriveSubsystem(sampleTankDrive);


        new  GamepadButton(new GamepadEx(gamepad2), GamepadKeys.Button.DPAD_UP)
                .whenPressed(()->pinza.dejar());

        new  GamepadButton(new GamepadEx(gamepad2), GamepadKeys.Button.DPAD_DOWN)
                .whenPressed(()->pinza.bajo());

        new GamepadButton(new GamepadEx(gamepad2), GamepadKeys.Button.DPAD_RIGHT)
                .whenPressed(()->pinza.medio());

        new  GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(()->pinza.abrir());

        new  GamepadButton(new GamepadEx(gamepad1), GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(()->pinza.cerrar());


        arm.setDefaultCommand(new ArmDefaultComand(arm, gamepadDriver, pinza));

        driveSubsystem.setDefaultCommand(new TankDriveComand(driveSubsystem, gamepadDriver::getLeftY, gamepadDriver::getRightX));
        schedule(new RunCommand(() -> {
         driveSubsystem.update();
            telemetry.addData("Heading", driveSubsystem.getPoseEstimate().getHeading());
            telemetry.update();
        }));

    }
}
