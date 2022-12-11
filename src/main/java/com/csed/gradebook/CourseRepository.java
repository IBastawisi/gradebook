package com.csed.gradebook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
  private List<Course> courses;

  public CourseRepository() {
    courses = new ArrayList<Course>();
  }

  public void addCourse(Course course) {
    courses.add(course);
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public int getCourseCount() {
    return courses.size();
  }

  public Course getCourseByCode(String courseCode) {
    for (Course course : courses) {
      if (course.getCourseCode().equals(courseCode)) {
        return course;
      }
    }
    return null;
  }

  public void removeCourseByCode(String courseCode) {
    for (int i = 0; i < courses.size(); i++) {
      if (courses.get(i).getCourseCode().equals(courseCode)) {
        courses.remove(i);
        return;
      }
    }
  }

  public void updateCourseByCode(String courseCode, Course Course) {
    for (int i = 0; i < courses.size(); i++) {
      if (courses.get(i).getCourseCode().equals(courseCode)) {
        courses.set(i, Course);
        return;
      }
    }
  }

  public void clear() {
    courses.clear();
  }

}
