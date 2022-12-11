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
@RequestMapping(path = "api/grades")
public class GradeController {

  private GradeService gradeService;

  public GradeController(GradeService gradeService) {
    this.gradeService = gradeService;
  }

  @GetMapping
  public List<Grade> getAllGrades() {
    return gradeService.getGrades();
  }

  @PostMapping
  public void addGrade(@RequestBody Grade grade) {
    gradeService.addGrade(grade);
  }

  // get grade by course code and student id
  @GetMapping(path = "{code}/{studentId}")
  public Grade getGrade(
      @PathVariable("code") String code,
      @PathVariable("studentId") String studentId) {
    return gradeService.getGradeByCourseCodeAndStudentId(code, studentId);
  }

  @PatchMapping(path = "{code}/{studentId}")
  public void updateGrade(
      @PathVariable("code") String code,
      @PathVariable("studentId") String studentId,
      @RequestBody Grade grade) {
    gradeService.updateGradeByCourseCodeAndStudentId(code, studentId, grade);
  }

  @DeleteMapping(path = "{code}/{studentId}")
  public void deleteGrade(
      @PathVariable("code") String code,
      @PathVariable("studentId") String studentId) {
    gradeService.removeGradeByCourseCodeAndStudentId(code, studentId);
  }

  // get grades by course code
  @GetMapping(path = "course/{code}")
  public List<Grade> getGradesByCourseCode(
      @PathVariable("code") String code) {
    return gradeService.getGradesByCourseCode(code);
  }

  // get grades by student id
  @GetMapping(path = "student/{studentId}")
  public List<Grade> getGradesByStudentId(
      @PathVariable("studentId") String studentId) {
    return gradeService.getGradesByStudentId(studentId);
  }
  
}