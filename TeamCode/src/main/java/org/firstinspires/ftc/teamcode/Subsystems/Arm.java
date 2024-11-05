package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm extends SubsystemBase {
    HardwareMap hardwareMap;
    Telemetry telemetry;

    DcMotorEx arm;

    public  Arm(HardwareMap hardwareMap, Telemetry telemetry){
        this.hardwareMap =  hardwareMap;
        this.telemetry =  telemetry;

        arm = hardwareMap.get(DcMotorEx.class, " arm");
    }

    public  void setPower(int power){
        setPower(power);
    }

    @Override
    public void periodic() {
        telemetry.addData("arm: ", arm.getCurrentPosition());
    }
}
