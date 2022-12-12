package com.csed.gradebook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
  private List<Course> courses;

  public CourseRepository() {
    courses = new ArrayList<Course>(){
      {
        add(new Course("1", "math 2", "CSE2", "Introduction to calculus", "prof. R.A", "2020", 150));
        add(new Course("2","math 3", "CSE3", "Introduction to linear algebra", "prof. S.S", "2021", 150));
        add(new Course("3","math 4", "CSE4", "Introduction to complex analysis", "prof. A.A", "2021", 150));
        add(new Course("4","math 5", "CSE5", "Introduction to numerical methods", "prof. M.A", "2022", 150));
      }
    };
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

  public Course getCourseById(String id) {
    for (Course course : courses) {
      if (course.getId().equals(id)) {
        return course;
      }
    }
    return null;
  }

  public void removeCourseById(String courseId) {
    for (int i = 0; i < courses.size(); i++) {
      if (courses.get(i).getId().equals(courseId)) {
        courses.remove(i);
        return;
      }
    }
  }

  public void updateCourseById(String courseId, Course Course) {
    for (int i = 0; i < courses.size(); i++) {
      if (courses.get(i).getId().equals(courseId)) {
        courses.set(i, Course);
        return;
      }
    }
  }

  public void clear() {
    courses.clear();
  }

}
