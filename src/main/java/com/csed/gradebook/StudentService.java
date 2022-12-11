package com.csed.gradebook;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
  private StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public void addStudent(Student student) {
    studentRepository.addStudent(student);
  }

  public List<Student> getStudents() {
    return studentRepository.getStudents();
  }

  public int getStudentCount() {
    return studentRepository.getStudentCount();
  }

  public Student getStudentById(String studentId) {
    return studentRepository.getStudentById(studentId);
  }

  public void removeStudentById(String studentId) {
    studentRepository.removeStudentById(studentId);
  }

  public void updateStudentById(String studentId, Student student) {
    studentRepository.updateStudentById(studentId, student);
  }

  public void clear() {
    studentRepository.clear();
  }
}
