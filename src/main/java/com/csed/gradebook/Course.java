package com.csed.gradebook;

public class Course {
  private String id;
  private String name;
  private String code;
  private String description;
  private String instructor;
  private String year;
  private int fullmark;

  public Course() {
  }

  public Course(String id, String name, String code, String description, String instructor,
      String Year, int fullmark) {
    this.id = id;
    this.name = name;
    this.code = code;
    this.description = description;
    this.instructor = instructor;
    this.year = Year;
    this.fullmark = fullmark;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getInstructor() {
    return instructor;
  }

  public void setInstructor(String instructor) {
    this.instructor = instructor;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String Year) {
    this.year = Year;
  }

  public int getFullmark() {
    return fullmark;
  }

  public void setFullmark(int fullmark) {
    this.fullmark = fullmark;
  }
}
