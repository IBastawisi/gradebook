import React, { useEffect } from 'react';
import logo from './logo.svg';
import './App.css';
import { DataGrid, GridColDef, GridValueGetterParams } from '@mui/x-data-grid';
import { courseService, gradeService, studentService } from './service';
import { CourseModel, GradeModel, StudentModel } from './model';
import { Typography } from '@mui/material';

function App() {
  const [studentModels, setStudentModels] = React.useState<StudentModel[]>([]);
  const [courseModels, setCourseModels] = React.useState<CourseModel[]>([]);
  const [gradeModels, setGradeModels] = React.useState<GradeModel[]>([]);


  useEffect(() => {
    studentService.getStudents().then((students) => {
      setStudentModels(students);
    });
    courseService.getCourses().then((courses) => {
      setCourseModels(courses);
    });
    gradeService.getGrades().then((grades) => {
      setGradeModels(grades);
    });
  }, []);

  const studentCols: GridColDef[] = [
    { field: 'id', headerName: 'ID', width: 70 },
    { field: 'name', headerName: 'Full Name', width: 280 },
    { field: 'email', headerName: 'Email Address', width: 280 },
  ];

  const courseCols: GridColDef[] = [
    { field: 'code', headerName: 'Course Code', width: 70 },
    { field: 'name', headerName: 'Course Name', width: 120 },
    { field: 'description', headerName: 'Description', width: 280 },
    { field: 'instructor', headerName: 'Instructor', width: 130 },
    { field: 'year', headerName: 'Year', width: 130 },
    { field: 'fullmark', headerName: 'Fullmark', width: 130 },
  ];

  const gradeCols: GridColDef[] = [
    { field: 'studentId', headerName: 'Student', width: 280 },
    { field: 'courseCode', headerName: 'Course', width: 280 },
    { field: 'degree', headerName: 'Degree', width: 280 },
  ];

  return (
    <div className="App">
      <Typography variant="overline" component="div" gutterBottom>
        Student List
      </Typography>
      <div style={{ height: 400, width: '100%' }}>
        <DataGrid
          rows={studentModels}
          columns={studentCols}
          pageSize={5}
          rowsPerPageOptions={[5]}
        />
      </div>
      <Typography variant="overline" component="div" gutterBottom>
        Course List
      </Typography>
      <div style={{ height: 400, width: '100%' }}>
        <DataGrid
          rows={courseModels}
          columns={courseCols}
          getRowId={(row) => row.code}
          pageSize={5}
          rowsPerPageOptions={[5]}
        />
      </div>
      <Typography variant="overline" component="div" gutterBottom>
        Grade List
      </Typography>
      <div style={{ height: 400, width: '100%' }}>
        <DataGrid
          rows={gradeModels}
          columns={gradeCols}
          getRowId={(row) => `${row.courseCode}-${row.studentId}}`}
          pageSize={5}
          rowsPerPageOptions={[5]}
        />
      </div>


    </div>
  );
}

export default App;
