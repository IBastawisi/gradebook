package com.csed.gradebook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class GradeRepository {
  private List<Grade> grades;

  public GradeRepository() {
    grades = new ArrayList<Grade>();
  }

  public void addGrade(Grade grade) {
    grades.add(grade);
  }

  public List<Grade> getGrades() {
    return grades;
  }

  public int getGradeCount() {
    return grades.size();
  }

  public List<Grade> getGradesByStudentId(String studentId) {
    ArrayList<Grade> studentGrades = new ArrayList<Grade>();
    for (Grade grade : grades) {
      if (grade.getStudentId().equals(studentId)) {
        studentGrades.add(grade);
      }
    }
    return studentGrades;
  }

  public List<Grade> getGradeByCourseCode(String courseCode) {
    ArrayList<Grade> courseGrades = new ArrayList<Grade>();
    for (Grade grade : grades) {
      if (grade.getCourseCode().equals(courseCode)) {
        courseGrades.add(grade);
      }
    }
    return courseGrades;
  }

  public Grade getGradeByCourseCodeAndStudentId(String courseCode, String studentId) {
    for (Grade grade : grades) {
      if (grade.getCourseCode().equals(courseCode) && grade.getStudentId().equals(studentId)) {
        return grade;
      }
    }
    return null;
  }

  public void removeGradeByCourseCodeAndStudentId(String courseCode, String studentId) {
    for (int i = 0; i < grades.size(); i++) {
      if (grades.get(i).getCourseCode().equals(courseCode) && grades.get(i).getStudentId().equals(studentId)) {
        grades.remove(i);
        return;
      }
    }
  }

  public void updateGradeByCourseCodeAndStudentId(String courseCode, String studentId, Grade grade) {
    for (int i = 0; i < grades.size(); i++) {
      if (grades.get(i).getCourseCode().equals(courseCode) && grades.get(i).getStudentId().equals(studentId)) {
        grades.set(i, grade);
        return;
      }
    }
  }

  public void clear() {
    grades.clear();
  }
}
