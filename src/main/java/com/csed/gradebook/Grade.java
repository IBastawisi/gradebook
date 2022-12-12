package com.csed.gradebook;

public class Grade {
  private String id;
  private String courseId;
  private String studentId;
  private double degree;

  public Grade() {
  }

  public Grade(String id, String courseId, String studentId, double degree) {
    this.id = id;
    this.courseId = courseId;
    this.studentId = studentId;
    this.degree = degree;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
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
