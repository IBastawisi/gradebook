package com.csed.gradebook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
  private List<Course> courses;

  public CourseRepository() {
    courses = new ArrayList<Course>() {
      {
        add(new Course("1", "math 1", "CSE1", "Differential Calculus & Linear Algebra", "R.A", 150));
        add(new Course("2", "math 2", "CSE2", "Integral Calculus & Analytical Geometry", "R.A", 150));
        add(new Course("3", "math 3", "CSE3", "Ordinary Differential Equations & Multivariable Functions", "G.B",
            150));
        add(new Course("4", "math 4", "CSE4", "Partial Differential Equations & Complex Analysis", "M.A", 150));
        add(new Course("5", "math 5", "CSE5", "Numerical Methods & Statistics", "M.A", 150));
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
