package com.csed.gradebook;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseService {
  private CourseRepository courseRepository;

  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public void addCourse(Course course) {
    courseRepository.addCourse(course);
  }

  public List<Course> getCourses() {
    return courseRepository.getCourses();
  }

  public Course getCourse(String courseId) {
    return courseRepository.getCourseById(courseId);
  }

  public void updateCourse(String courseId, Course course) {
    courseRepository.updateCourseById(courseId, course);
  }

  public void removeCourse(String courseId) {
    courseRepository.removeCourseById(courseId);
  }

  public void clear() {
    courseRepository.clear();
  }
}
