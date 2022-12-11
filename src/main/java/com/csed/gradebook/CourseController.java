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
@RequestMapping(path = "api/courses")
public class CourseController {

  private CourseService courseService;

  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  @GetMapping
  public List<Course> getAllCourses() {
    return courseService.getCourses();
  }

  @PostMapping
  public void addCourse(@RequestBody Course course) {
    courseService.addCourse(course);
  }

  @GetMapping(path = "{code}")
  public Course getCourse(
      @PathVariable("code") String code) {
    return courseService.getCourse(code);
  }

  @PatchMapping(path = "{code}")
  public void updateCourse(
      @PathVariable("code") String code,
      @RequestBody Course course) {
    courseService.updateCourse(code, course);
  }

  @DeleteMapping(path = "{code}")
  public void deleteCourse(
      @PathVariable("code") String code) {
    courseService.removeCourse(code);
  }
}