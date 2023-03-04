// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class MoveRollers extends CommandBase {
  /** Creates a new MoveRollers. */

  int state = 0;

  public MoveRollers() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_rollers);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean m_leftBumper = RobotContainer.m_controller.getLeftBumperPressed();

    switch(state){
      case 0:
        if(m_leftBumper) state = 1;
        break;
      case 1:
        RobotContainer.m_rollers.moveRollers("OUT");
        state = 2;
        break;
      case 2:
        if(m_leftBumper) state = 3;
        break;
      case 3:
        RobotContainer.m_rollers.moveRollers("IN");
        state = 4;
        break;
      case 4:
        if(m_leftBumper) state = 1;
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
