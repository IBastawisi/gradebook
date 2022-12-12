package com.csed.gradebook;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/students")
public class StudentController {

  private StudentService studentService;
  private GradeService gradeService;

  public StudentController(StudentService studentService, GradeService gradeService) {
    this.studentService = studentService;
    this.gradeService = gradeService;
  }

  @GetMapping
  public List<Student> getAllStudents() {
    return studentService.getStudents();
  }

  @PostMapping
  public void addStudent(@RequestBody Student student) {
    studentService.addStudent(student);
  }

  @GetMapping(path = "{id}")
  public Student getStudentById(
      @PathVariable("id") String id) {
    return studentService.getStudentById(id);
  }

  @PutMapping(path = "{id}")
  public void updateStudentById(
      @PathVariable("id") String id,
      @RequestBody Student student) {
    studentService.updateStudentById(id, student);
  }

  @DeleteMapping(path = "{id}")
  public void deleteStudent(
      @PathVariable("id") String id) {
    studentService.removeStudentById(id);
    gradeService.removeGradesByStudentId(id);
  }
}