import React, { useEffect } from 'react';
import './App.css';
import { GridColDef } from '@mui/x-data-grid';
import { courseService, gradeService, studentService } from './service';
import { CourseModel, GradeModel, StudentModel } from './model';
import DataTable from './DataTable';

function App() {
  const [studentModels, setStudentModels] = React.useState<StudentModel[]>([]);
  const [courseModels, setCourseModels] = React.useState<CourseModel[]>([]);
  const [gradeModels, setGradeModels] = React.useState<GradeModel[]>([]);


  useEffect(() => {
    studentService.getAll().then((students) => {
      setStudentModels(students);
    });
    courseService.getAll().then((courses) => {
      setCourseModels(courses);
    });
    gradeService.getAll().then((grades) => {
      setGradeModels(grades);
    });
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  useEffect(() => {
    if (gradeModels.length === 0) return;
    setGradeModels(gradeModels.filter((grade) => {
      const student = studentModels.find((student) => student.id === grade.studentId);
      const course = courseModels.find((course) => course.id === grade.courseId);
      return student && course;
    }));
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [studentModels, courseModels]);

  const studentCols: GridColDef[] = [
    { field: 'id', headerName: 'ID', width: 70 },
    { field: 'name', headerName: 'Full Name', width: 280, editable: true },
    { field: 'email', headerName: 'Email Address', width: 280, editable: true },
  ];

  const courseCols: GridColDef[] = [
    { field: 'id', headerName: 'ID', width: 70 },
    { field: 'code', headerName: 'Code', width: 70, editable: true },
    { field: 'name', headerName: 'Name', width: 130, editable: true },
    { field: 'description', headerName: 'Description', width: 280, editable: true },
    { field: 'instructor', headerName: 'Instructor', width: 130, editable: true },
    { field: 'year', headerName: 'Year', width: 70, editable: true },
    { field: 'fullmark', headerName: 'Fullmark', width: 70, editable: true },
  ];

  const gradeCols: GridColDef[] = [
    { field: 'id', headerName: 'ID', width: 70 },
    { field: 'studentId', headerName: 'Student ID', width: 70, editable: true },
    { field: 'courseId', headerName: 'Course Id', width: 70, editable: true },
    { field: 'degree', headerName: 'Degree', width: 70, editable: true },
    { field: 'name', headerName: 'Student Name', width: 280 },
    { field: 'course', headerName: 'Course Name', width: 70 },
    { field: 'fullmark', headerName: 'Fullmark', width: 70 },
    { field: 'grade', headerName: 'Grade', width: 70 },
  ];

  const calculateGrade = (degree: number, fullmark: number | undefined) => {
    if (fullmark) {
      const percentage = (degree / fullmark) * 100;
      if (percentage >= 90) {
        return 'A';
      } else if (percentage >= 80) {
        return 'B';
      } else if (percentage >= 70) {
        return 'C';
      } else if (percentage >= 60) {
        return 'D';
      } else {
        return 'F';
      }
    }
    return 'N/A';
  };

  const getGrades = () => gradeModels.map((grade) => {
    const student = studentModels.find((student) => student.id === grade.studentId);
    const course = courseModels.find((course) => course.id === grade.courseId);
    return {
      ...grade,
      name: student?.name,
      course: course?.name,
      degree: grade.degree,
      fullmark: course?.fullmark,
      grade: calculateGrade(grade.degree, course?.fullmark),
    };
  });

  return (
    <div className="App">
      <DataTable title="Student List" rows={studentModels} setRows={setStudentModels} dataColumns={studentCols} service={studentService} />
      <DataTable title="Course List" rows={courseModels} setRows={setCourseModels} dataColumns={courseCols} service={courseService} />
      <DataTable title="Grade List" rows={getGrades()} setRows={setGradeModels} dataColumns={gradeCols} service={gradeService} />
    </div>
  );
}

export default App;
