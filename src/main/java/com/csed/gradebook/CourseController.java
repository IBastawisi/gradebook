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
@RequestMapping(path = "api/courses")
public class CourseController {

  private CourseService courseService;
  private GradeService gradeService;

  public CourseController(CourseService courseService, GradeService gradeService) {
    this.courseService = courseService;
    this.gradeService = gradeService;
  }

  @GetMapping
  public List<Course> getAllCourses() {
    return courseService.getCourses();
  }

  @PostMapping
  public void addCourse(@RequestBody Course course) {
    courseService.addCourse(course);
  }

  @GetMapping(path = "{id}")
  public Course getCourse(
      @PathVariable("id") String id) {
    return courseService.getCourse(id);
  }

  @PutMapping(path = "{id}")
  public void updateCourse(
      @PathVariable("id") String id,
      @RequestBody Course course) {
    courseService.updateCourse(id, course);
  }

  @DeleteMapping(path = "{id}")
  public void deleteCourse(
      @PathVariable("id") String id) {
    courseService.removeCourse(id);
    gradeService.removeGradesByCourseId(id);
  }
}