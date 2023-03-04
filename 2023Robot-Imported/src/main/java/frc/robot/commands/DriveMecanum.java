// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveMecanum extends CommandBase {
  /** Creates a new DriveMecanum. */
  public DriveMecanum() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double m_leftY = RobotContainer.m_controller.getLeftY();
    double m_leftX = -RobotContainer.m_controller.getLeftX();
    double m_rightX = RobotContainer.m_controller.getRightX();
    //boolean m_aButton = RobotContainer.m_controller1.getAButtonPressed();
    //boolean m_bButton = RobotContainer.m_controller1.getBButtonPressed();

    if(m_leftY < 0.25 && m_leftY > -0.25){
      m_leftY = 0;
    }
    if(m_leftX < 0.25 && m_leftX > -0.25){
      m_leftX = 0;
    }
    if(m_rightX < 0.25 && m_rightX > -0.25){
      m_rightX = 0;
    }

    RobotContainer.m_drivetrain.mecanumDrive(m_rightX, m_leftY, m_leftX);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_drivetrain.mecanumDrive(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
