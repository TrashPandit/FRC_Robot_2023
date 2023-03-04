// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class MoveArm extends CommandBase {
  /** Creates a new MoveArm. */

  int extenderState = 0;
  int clawState = 0;
  int liftState = 0;
  int moverState = 0;

  public MoveArm() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean m_BButton = RobotContainer.m_controller.getBButtonPressed();
    boolean m_YButton = RobotContainer.m_controller.getYButtonPressed();
    boolean m_Abutton = RobotContainer.m_controller.getAButton();
    boolean m_XButton = RobotContainer.m_controller.getXButtonPressed();
    boolean m_rightBumper = RobotContainer.m_controller.getRightBumper();

    if(m_rightBumper){
      RobotContainer.m_arm.moveMover("IN");
    }
    else if(m_Abutton){
      RobotContainer.m_arm.moveMover("OUT");
    }
    else{
      RobotContainer.m_arm.moveMover("OFF");
    }

    switch(extenderState){
      case 0:
        if(m_YButton) extenderState = 1;
        break;
      case 1:
        RobotContainer.m_arm.moveExtender("OUT");
        extenderState = 2;
        break;
      case 2:
        if(m_YButton) extenderState = 3;
        break;
      case 3:
        RobotContainer.m_arm.moveExtender("IN");
        extenderState = 4;
        break;
      case 4:
        if(m_YButton) extenderState = 1;
        break;
    }

    switch(clawState){
      case 0:
        if(m_XButton) clawState = 1;
        break;
      case 1:
        RobotContainer.m_arm.moveClaw("OUT");
        clawState = 2;
        break;
      case 2:
        if(m_XButton) clawState = 3;
        break;
      case 3:
        RobotContainer.m_arm.moveClaw("IN");
        clawState = 4;
        break;
      case 4:
        if(m_XButton) clawState = 1;
        break;
    }

    switch(liftState){
      case 0:
        if(m_BButton) liftState = 1;
        break;
      case 1:
        RobotContainer.m_arm.moveLift("OUT");
        liftState = 2;
        break;
      case 2:
        if(m_BButton) liftState = 3;
        break;
      case 3:
        RobotContainer.m_arm.moveLift("IN");
        liftState = 4;
        break;
      case 4:
        if(m_BButton) liftState = 1;
        break;
    }
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
