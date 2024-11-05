package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Pinza extends SubsystemBase {

    ServoEx muñeca1, muñeca2, ser1, ser2;

    DcMotorEx intake;
    HardwareMap hardwareMap;
    Telemetry telemetry;

    public  Pinza(HardwareMap hardwareMap, Telemetry telemetry){
this.hardwareMap = hardwareMap;
this.telemetry = telemetry;

intake = hardwareMap.get(DcMotorImplEx.class, "intake");
muñeca2 =  new SimpleServo(hardwareMap, "muñeca1", 0, 180, AngleUnit.DEGREES);
muñeca1 = new SimpleServo(hardwareMap, " muñeca2", 0, 180, AngleUnit.DEGREES);
ser2 = new SimpleServo(hardwareMap, "ser2", 0, 180, AngleUnit.DEGREES);
ser1 = new SimpleServo(hardwareMap, "ser1", 0, 180, AngleUnit.DEGREES);
ser1.setInverted(true);
ser2.setInverted(false);
    }


    public void bajo(){
        muñeca1.turnToAngle(0);
        muñeca2.turnToAngle(0);
    }

    public  void  medio(){
        muñeca1.turnToAngle(90)
        ;
        muñeca2.turnToAngle(90);
    }
public  void dejar(){
        muñeca1.turnToAngle(100);
        muñeca2.turnToAngle(100);
}

public  void cerrar(){
        ser1.turnToAngle(0);
        ser2.turnToAngle(0);
}
public  void abrir(){
        ser2.turnToAngle(170);
        ser1.turnToAngle(170);
}
    @Override
    public void periodic() {
        telemetry.addData("ser1: ", ser1.getAngle());
        telemetry.addData("ser2: ", ser2.getAngle());
        telemetry.addData("muñeca1:", muñeca1.getAngle());
        telemetry.addData("muñeca2:", muñeca2.getAngle());
    }
}
