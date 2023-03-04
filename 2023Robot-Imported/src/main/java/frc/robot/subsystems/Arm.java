// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */

  DoubleSolenoid m_extender;
  DoubleSolenoid m_claw;
  DoubleSolenoid m_lift;
  DoubleSolenoid m_mover;
  Spark m_wristMotor;
  Encoder m_wristEncoder;
  
  public Arm() {
    m_extender = new DoubleSolenoid(1, PneumaticsModuleType.CTREPCM, Constants.ARM_EXTENDER_OUT, Constants.ARM_EXTENDER_IN);
    m_claw = new DoubleSolenoid(1, PneumaticsModuleType.CTREPCM, Constants.ARM_CLAW_OUT, Constants.ARM_CLAW_IN);
    m_lift = new DoubleSolenoid(1, PneumaticsModuleType.CTREPCM, Constants.ARM_LIFT_OUT, Constants.ARM_LIFT_IN);
    m_mover = new DoubleSolenoid(1, PneumaticsModuleType.CTREPCM, Constants.ARM_MOVER_OUT, Constants.ARM_MOVER_IN);
    m_wristMotor = new Spark(Constants.WRIST_SPARK);

  }

  public void moveExtender(String direction){
    if(direction.equalsIgnoreCase("OUT")){
      m_extender.set(Value.kForward);
    }  
    else if(direction.equalsIgnoreCase("IN")){
      m_extender.set(Value.kReverse);
    }
    else{
      m_extender.set(Value.kOff);
    }
  }

  public void moveClaw(String direction){
    if(direction.equalsIgnoreCase("OUT")){
      m_claw.set(Value.kForward);
    }  
    else if(direction.equalsIgnoreCase("IN")){
      m_claw.set(Value.kReverse);
    }
    else{
      m_claw.set(Value.kOff);
    }
  }

  public void moveLift(String direction){
    if(direction.equalsIgnoreCase("OUT")){
      m_lift.set(Value.kForward);
    }  
    else if(direction.equalsIgnoreCase("IN")){
      m_lift.set(Value.kReverse);
    }
    else{
      m_lift.set(Value.kOff);
    }
  }

  public void moveMover(String direction){
    if(direction.equalsIgnoreCase("OUT")){
      m_mover.set(Value.kForward);
    }  
    else if(direction.equalsIgnoreCase("IN")){
      m_mover.set(Value.kReverse);
    }
    else{
      m_mover.set(Value.kOff);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
