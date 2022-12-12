export interface StudentModel {
  id: string;
  name: string;
  email: string;
}

export interface CourseModel {
  id: string;
  code: string;
  name: string;
  description: string;
  instructor: string;
  year: string;
  fullmark: number;
}

export interface GradeModel {
  id: string;
  studentId: string;
  courseId: string;
  degree: number;
}
