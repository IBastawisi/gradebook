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

  public Course getCourse(String courseCode) {
    List<Course> courses = courseRepository.getCourses();
    for (Course course : courses) {
      if (course.getCourseCode().equals(courseCode)) {
        return course;
      }
    }
    return null;
  }

  public void removeCourse(String courseCode) {
    List<Course> courses = courseRepository.getCourses();
    for (int i = 0; i < courses.size(); i++) {
      if (courses.get(i).getCourseCode().equals(courseCode)) {
        courses.remove(i);
        return;
      }
    }
  }

  public void updateCourse(String courseCode, Course course) {
    List<Course> courses = courseRepository.getCourses();
    for (int i = 0; i < courses.size(); i++) {
      if (courses.get(i).getCourseCode().equals(courseCode)) {
        courses.set(i, course);
        return;
      }
    }
  }

  public void clear() {
    courseRepository.clear();
  }
}
