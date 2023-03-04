// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  Spark m_leftFrontSpark = null;
  Spark m_leftBackSpark = null;
  Spark m_rightFrontSpark = null;
  Spark m_rightBackSpark = null;

  MecanumDrive mecanumDrive = null;

  public Drivetrain() {
    m_leftFrontSpark = new Spark(Constants.DRIVETRAIN_LEFT_FRONT_SPARK);
    m_leftBackSpark = new Spark(Constants.DRIVETRAIN_LEFT_BACK_SPARK);
    m_rightFrontSpark = new Spark(Constants.DRIVETRAIN_RIGHT_FRONT_SPARK);
    m_rightBackSpark = new Spark(Constants.DRIVETRAIN_RIGHT_BACK_SPARK);

    m_rightFrontSpark.setInverted(false);
    m_rightBackSpark.setInverted(false);
    m_leftBackSpark.setInverted(false);
    m_leftFrontSpark.setInverted(false);

    mecanumDrive = new MecanumDrive(m_leftFrontSpark, m_leftBackSpark, m_rightFrontSpark, m_rightBackSpark);
  }

  public void mecanumDrive(double ySpeed, double xSpeed, double zRotation){
    mecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
