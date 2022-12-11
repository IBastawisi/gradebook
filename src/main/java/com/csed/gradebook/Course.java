package com.csed.gradebook;

public class Course {
  private String name;
  private String code;
  private String description;
  private String instructor;
  private String year;
  private int fullmark;

  public Course(String name, String code, String description, String instructor,
      String Year, int fullmark) {
    this.name = name;
    this.code = code;
    this.description = description;
    this.instructor = instructor;
    this.year = Year;
    this.fullmark = fullmark;
  }

  public String getCourseName() {
    return name;
  }

  public void setCourseName(String name) {
    this.name = name;
  }

  public String getCourseCode() {
    return code;
  }

  public void setCourseCode(String code) {
    this.code = code;
  }

  public String getCourseDescription() {
    return description;
  }

  public void setCourseDescription(String description) {
    this.description = description;
  }

  public String getCourseInstructor() {
    return instructor;
  }

  public void setCourseInstructor(String instructor) {
    this.instructor = instructor;
  }

  public String getCourseYear() {
    return year;
  }

  public void setCourseYear(String Year) {
    this.year = Year;
  }

  public int getCourseFullmark() {
    return fullmark;
  }

  public void setCourseFullmark(int fullmark) {
    this.fullmark = fullmark;
  }
}
