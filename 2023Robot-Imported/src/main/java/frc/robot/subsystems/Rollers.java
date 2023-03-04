// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Rollers extends SubsystemBase {
  /** Creates a new Rollers. */
  
  DoubleSolenoid m_rollingUnit; 

  public Rollers() {
    m_rollingUnit = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, Constants.ROLLERS_SOLENOID_OUT, Constants.ROLLERS_SOLENOID_IN);
  }

    public void moveRollers(String direction){
    if(direction.equalsIgnoreCase("OUT")){
      m_rollingUnit.set(Value.kForward);
    }  
    else if(direction.equalsIgnoreCase("IN")){
      m_rollingUnit.set(Value.kReverse);
    }
    else{
      m_rollingUnit.set(Value.kOff);
    }
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
