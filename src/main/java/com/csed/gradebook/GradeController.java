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

  @GetMapping(path = "{id}")
  public Grade getGradeById(
      @PathVariable("id") String id) {
    return gradeService.getGradeById(id);
  }

  @PutMapping(path = "{id}")
  public void updateGradeById(
      @PathVariable("id") String id,
      @RequestBody Grade grade) {
    gradeService.updateGradeById(id, grade);
  }

  @DeleteMapping(path = "{id}")
  public void deleteGrade(
      @PathVariable("id") String id) {
    gradeService.removeGradeById(id);
  }

  // get grades by course id
  @GetMapping(path = "course/{id}")
  public List<Grade> getGradesByCourseId(
      @PathVariable("id") String id) {
    return gradeService.getGradesByCourseId(id);
  }

  // get grades by student id
  @GetMapping(path = "student/{studentId}")
  public List<Grade> getGradesByStudentId(
      @PathVariable("studentId") String studentId) {
    return gradeService.getGradesByStudentId(studentId);
  }

}