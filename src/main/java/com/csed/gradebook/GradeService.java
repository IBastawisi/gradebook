package com.csed.gradebook;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GradeService {
  private GradeRepository gradeRepository;

  public GradeService(GradeRepository gradeRepository) {
    this.gradeRepository = gradeRepository;
  }

  public void addGrade(Grade grade) {
    gradeRepository.addGrade(grade);
  }

  public List<Grade> getGrades() {
    return gradeRepository.getGrades();
  }

  public int getGradeCount() {
    return gradeRepository.getGradeCount();
  }

  public Grade getGradeById(String gradeId) {
    return gradeRepository.getGradeById(gradeId);
  }

  public void updateGradeById(String gradeId, Grade grade) {
    gradeRepository.updateGradeById(grade);
  }

  public void removeGradeById(String gradeId) {
    gradeRepository.removeGradeById(gradeId);
  }

  public List<Grade> getGradesByStudentId(String studentId) {
    return gradeRepository.getGradesByStudentId(studentId);
  }

  public List<Grade> getGradesByCourseId(String courseId) {
    return gradeRepository.getGradeByCourseId(courseId);
  }

  public void removeGradesByStudentId(String studentId) {
    gradeRepository.removeGradesByStudentId(studentId);
  }

  public void removeGradesByCourseId(String courseId) {
    gradeRepository.removeGradesByCourseId(courseId);
  }

  public void clear() {
    gradeRepository.clear();
  }
}
