package com.csed.gradebook;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/students")
public class StudentController {

  private StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getAllStudents() {
    return studentService.getStudents();
  }

  @PostMapping
  public void addStudent(@RequestBody Student student) {
    studentService.addStudent(student);
  }

  @GetMapping(path = "{studentId}")
  public Student getStudentById(
      @PathVariable("studentId") String studentId) {
    return studentService.getStudentById(studentId);
  }

  @PatchMapping(path = "{studentId}")
  public void updateStudentById(
      @PathVariable("studentId") String studentId,
      @RequestBody Student student) {
    studentService.updateStudentById(studentId, student);
  }

  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(
      @PathVariable("studentId") String studentId) {
    studentService.removeStudentById(studentId);
  }
}