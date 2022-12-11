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

  public List<Grade> getGradesByStudentId(String studentId) {
    return gradeRepository.getGradesByStudentId(studentId);
  }

  public List<Grade> getGradesByCourseCode(String courseCode) {
    return gradeRepository.getGradeByCourseCode(courseCode);
  }

  public Grade getGradeByCourseCodeAndStudentId(String courseCode, String studentId) {
    return gradeRepository.getGradeByCourseCodeAndStudentId(courseCode, studentId);
  }

  public void removeGradeByCourseCodeAndStudentId(String courseCode, String studentId) {
    gradeRepository.removeGradeByCourseCodeAndStudentId(courseCode, studentId);
  }

  public void updateGradeByCourseCodeAndStudentId(String courseCode, String studentId, Grade grade) {
    gradeRepository.updateGradeByCourseCodeAndStudentId(courseCode, studentId, grade);
  }

  public void clear() {
    gradeRepository.clear();
  }
}
