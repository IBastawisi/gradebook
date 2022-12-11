import { CourseModel, GradeModel, StudentModel } from "./model";

// const baseUrl = "http://localhost:5000";
const baseUrl = "https://s5.ibastawisi.ml";

const getStudents = async () => {
  const response = await fetch(`${baseUrl}/api/students`);
  return response.json() as Promise<StudentModel[]>;
}

const getStudent = async (id: string) => {
  const response = await fetch(`${baseUrl}/api/students/${id}`);
  return response.json() as Promise<StudentModel>;
}

const postStudent = async (student: StudentModel) => {
  const response = await fetch(`${baseUrl}/api/students`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(student)
  });
  return response.json() as Promise<void>;
}

const patchStudent = async (student: StudentModel) => {
  const response = await fetch(`${baseUrl}/api/students/${student.id}`, {
    method: "PATCH",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(student)
  });
  return response.json() as Promise<void>;
}

const deleteStudent = async (id: string) => {
  const response = await fetch(`${baseUrl}/api/students/${id}`, {
    method: "DELETE"
  });
  return response.json() as Promise<void>;
}

export const studentService = {
  getStudents,
  getStudent,
  postStudent,
  patchStudent,
  deleteStudent
};

const getCourses = async () => {
  const response = await fetch(`${baseUrl}/api/courses`);
  return response.json() as Promise<CourseModel[]>;
}

const getCourse = async (code: string) => {
  const response = await fetch(`${baseUrl}/api/courses/${code}`);
  return response.json() as Promise<CourseModel>;
}

const postCourse = async (course: CourseModel) => {
  const response = await fetch(`${baseUrl}/api/courses`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(course)
  });
  return response.json() as Promise<void>;
}

const patchCourse = async (course: CourseModel) => {
  const response = await fetch(`${baseUrl}/api/courses/${course.code}`, {
    method: "PATCH",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(course)
  });
  return response.json() as Promise<void>;
}

const deleteCourse = async (code: string) => {
  const response = await fetch(`${baseUrl}/api/courses/${code}`, {
    method: "DELETE"
  });
  return response.json() as Promise<void>;
}

export const courseService = {
  getCourses,
  getCourse,
  postCourse,
  patchCourse,
  deleteCourse
};

const getGrades = async () => {
  const response = await fetch(`${baseUrl}/api/grades`);
  return response.json() as Promise<GradeModel[]>;
}

const getGrade = async (studentId: string, courseCode: string) => {
  const response = await fetch(`${baseUrl}/api/grades/${courseCode}/${studentId}`);
  return response.json() as Promise<GradeModel>;
}

const postGrade = async (grade: GradeModel) => {
  const response = await fetch(`${baseUrl}/api/grades`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(grade)
  });
  return response.json() as Promise<void>;
}

const patchGrade = async (grade: GradeModel) => {
  const response = await fetch(`${baseUrl}/api/grades/${grade.courseCode}/${grade.studentId}`, {
    method: "PATCH",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(grade)
  });
  return response.json() as Promise<void>;
}

const deleteGrade = async (studentId: string, courseCode: string) => {
  const response = await fetch(`${baseUrl}/api/grades/${courseCode}/${studentId}`, {
    method: "DELETE"
  });
  return response.json() as Promise<void>;
}

const getGradesByStudent = async (studentId: string) => {
  const response = await fetch(`${baseUrl}/api/grades/student/${studentId}`);
  return response.json() as Promise<GradeModel[]>;
}

const getGradesByCourse = async (courseCode: string) => {
  const response = await fetch(`${baseUrl}/api/grades/course/${courseCode}`);
  return response.json() as Promise<GradeModel[]>;
}

export const gradeService = {
  getGrades,
  getGrade,
  postGrade,
  patchGrade,
  deleteGrade,
  getGradesByStudent,
  getGradesByCourse
};