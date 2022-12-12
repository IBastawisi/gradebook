import { CourseModel, GradeModel, StudentModel } from "./model";

const baseUrl = "http://localhost:5000";
// const baseUrl = "https://s5.ibastawisi.ml";

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
  return response;
}

const putStudent = async (student: StudentModel) => {
  const response = await fetch(`${baseUrl}/api/students/${student.id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(student)
  });
  return response;
}

const deleteStudent = async (id: string) => {
  const response = await fetch(`${baseUrl}/api/students/${id}`, {
    method: "DELETE"
  });
  return response;
}

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
  return response;
}

const putCourse = async (course: CourseModel) => {
  const response = await fetch(`${baseUrl}/api/courses/${course.code}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(course)
  });
  return response;
}

const deleteCourse = async (code: string) => {
  const response = await fetch(`${baseUrl}/api/courses/${code}`, {
    method: "DELETE"
  });
  return response;
}

const getGrades = async () => {
  const response = await fetch(`${baseUrl}/api/grades`);
  return response.json() as Promise<GradeModel[]>;
}

const getGrade = async (studentId: string, courseId: string) => {
  const response = await fetch(`${baseUrl}/api/grades/${courseId}/${studentId}`);
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
  return response;
}

const putGrade = async (grade: GradeModel) => {
  const response = await fetch(`${baseUrl}/api/grades/${grade.id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(grade)
  });
  return response;
}

const deleteGrade = async (id: string) => {
  const response = await fetch(`${baseUrl}/api/grades/${id}`, {
    method: "DELETE"
  });
  return response;
}

// const getGradesByStudent = async (studentId: string) => {
//   const response = await fetch(`${baseUrl}/api/grades/student/${studentId}`);
//   return response.json() as Promise<GradeModel[]>;
// }

// const getGradesByCourse = async (courseId: string) => {
//   const response = await fetch(`${baseUrl}/api/grades/course/${courseId}`);
//   return response.json() as Promise<GradeModel[]>;
// }

export const studentService = {
  getAll: getStudents,
  get: getStudent,
  post: postStudent,
  put: putStudent,
  delete: deleteStudent
};

export const courseService = {
  getAll: getCourses,
  get: getCourse,
  post: postCourse,
  put: putCourse,
  delete: deleteCourse
};


export const gradeService = {
  getAll: getGrades,
  get: getGrade,
  post: postGrade,
  put: putGrade,
  delete: deleteGrade,
};

export type Service = typeof studentService | typeof courseService | typeof gradeService;