export interface StudentModel {
  id: string;
  name: string;
  email: string;
}

export interface CourseModel {
  code: string;
  name: string;
  description: string;
  instructor: string;
  year: string;
  fullmark: number;
}

export interface GradeModel {
  studentId: string;
  courseCode: string;
  degree: number;
}

export interface Student {
  id: string;
  name: string;
  email: string;
  courses: CourseModel[];

}

export interface Course {
  code: string;
  name: string;
  description: string;
  instructor: string;
  year: string;
  fullmark: number;
  students: StudentModel[];
}

export interface Grade {
  studentId: string;
  courseCode: string;
  degree: number;
  student: Student;
  course: Course;
}