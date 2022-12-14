package com.csed.gradebook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class GradeRepository {
  private List<Grade> grades;

  public GradeRepository() {
    grades = new ArrayList<Grade>() {
      {
        add(new Grade("1", "1", "1", 121));
        add(new Grade("2", "1", "2", 90));
        add(new Grade("3", "1", "3", 100));
        add(new Grade("4", "2", "1", 83));
        add(new Grade("5", "2", "2", 80));
        add(new Grade("6", "2", "3", 90));
        add(new Grade("7", "3", "1", 111));
        add(new Grade("8", "3", "3", 110));
        add(new Grade("9", "4", "1", 126));
        add(new Grade("10", "5", "3", 120));
      }
    };
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

  public Grade getGradeById(String id) {
    for (Grade grade : grades) {
      if (grade.getId().equals(id)) {
        return grade;
      }
    }
    return null;
  }

  public void updateGradeById(Grade grade) {
    for (int i = 0; i < grades.size(); i++) {
      if (grades.get(i).getId().equals(grade.getId())) {
        grades.set(i, grade);
      }
    }
  }

  public void removeGradeById(String gradeId) {
    for (int i = 0; i < grades.size(); i++) {
      if (grades.get(i).getId().equals(gradeId)) {
        grades.remove(i);
      }
    }
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

  public List<Grade> getGradeByCourseId(String courseId) {
    ArrayList<Grade> courseGrades = new ArrayList<Grade>();
    for (Grade grade : grades) {
      if (grade.getCourseId().equals(courseId)) {
        courseGrades.add(grade);
      }
    }
    return courseGrades;
  }

  public void removeGradesByStudentId(String studentId) {
    grades.removeIf(grade -> grade.getStudentId().equals(studentId));
  }

  public void removeGradesByCourseId(String courseId) {
    grades.removeIf(grade -> grade.getCourseId().equals(courseId));
  }

  public void clear() {
    grades.clear();
  }
}
