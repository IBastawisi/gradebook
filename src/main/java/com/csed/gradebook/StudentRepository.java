package com.csed.gradebook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
  private List<Student> students;

  public StudentRepository() {
    students = new ArrayList<Student>();
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  public int getStudentCount() {
    return students.size();
  }

  public Student getStudentById(String studentId) {
    for (Student student : students) {
      if (student.getId().equals(studentId)) {
        return student;
      }
    }
    return null;
  }

  public void removeStudentById(String studentId) {
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getId().equals(studentId)) {
        students.remove(i);
        return;
      }
    }
  }

  public void updateStudentById(String studentId, Student student) {
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getId().equals(studentId)) {
        students.set(i, student);
        return;
      }
    }
  }

  public void clear() {
    students.clear();
  }

}
