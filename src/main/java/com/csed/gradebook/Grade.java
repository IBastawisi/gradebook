package com.csed.gradebook;

public class Grade {
  private String courseCode;
  private String studentId;
  private double degree;


  public Grade(String courseCode, String studentId, double degree) {
    this.courseCode = courseCode;
    this.studentId = studentId;
    this.degree = degree;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public double getDegree() {
    return degree;
  }

  public void setDegree(double degree) {
    this.degree = degree;
  }
}
