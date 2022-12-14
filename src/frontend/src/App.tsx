import React, { useEffect } from 'react';
import './App.css';
import { GridColDef, GridRenderEditCellParams } from '@mui/x-data-grid';
import { courseService, gradeService, studentService } from './service';
import { CourseModel, GradeModel, StudentModel } from './model';
import DataTable from './DataTable';
import IDSelect from './AutoComplete';
import ReactApexChart from 'react-apexcharts';
import { ApexOptions } from 'apexcharts';
import AppBar from '@mui/material/AppBar';
import Typography from '@mui/material/Typography';
import Toolbar from '@mui/material/Toolbar';
import Box from '@mui/material/Box';

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
    { field: 'fullmark', headerName: 'Fullmark', width: 100, type: "number", editable: true },
  ];

  const gradeCols: GridColDef[] = [
    { field: 'id', headerName: 'ID', width: 70 },
    {
      field: 'studentId', headerName: 'Student ID', width: 200, editable: true,
      renderEditCell: (params: GridRenderEditCellParams) => <IDSelect options={studentModels} {...params} />
    },
    {
      field: 'courseId', headerName: 'Course ID', width: 130, editable: true,
      renderEditCell: (params: GridRenderEditCellParams) => <IDSelect options={courseModels} {...params} />
    },
    { field: 'degree', headerName: 'Degree', width: 100, type: "number", editable: true },
    { field: 'name', headerName: 'Student', width: 280 },
    { field: 'course', headerName: 'Course', width: 70 },
    { field: 'fullmark', headerName: 'Fullmark', width: 70 },
    { field: 'grade', headerName: 'Grade', width: 70 },
  ];

  const calculateGrade = (degree: number, fullmark: number | undefined) => {
    if (fullmark) {
      const percentage = (degree / fullmark) * 100;
      if (percentage >= 85) {
        return 'A';
      } else if (percentage >= 75) {
        return 'B';
      } else if (percentage >= 65) {
        return 'C';
      } else if (percentage >= 50) {
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

  const getStudentsCourseGradesChartOptions = () => {

    const options: ApexOptions = {
      chart: {
        type: 'bar',
        height: 350,
        stacked: true,
      },
      plotOptions: {
        bar: {
          horizontal: true,
          dataLabels: {
            total: {
              enabled: true,
              offsetX: 0,
              style: {
                fontSize: '13px',
                fontWeight: 900
              }
            }
          }
        },
      },
      stroke: {
        width: 1,
        colors: ['#fff']
      },
      xaxis: {
        categories: studentModels.map((student) => student.name),
      },
      yaxis: {
        title: {
          text: undefined
        },
      },
      fill: {
        opacity: 1
      },
      legend: {
        position: 'top',
        horizontalAlign: 'left',
        offsetX: 40
      }
    }
    return options;
  }

  const getStudentsCourseGradesSeries = () => {
    const series: ApexAxisChartSeries = [...courseModels].sort((a, b) => +a.id - +b.id)
      .map((course) => {
        const Grades = [...studentModels].sort((a, b) => +a.id - +b.id).map((student) => {
          const grade = gradeModels.find((grade) => grade.studentId === student.id && grade.courseId === course.id);
          return grade ? grade.degree : 0;
        });

        return {
          name: course.name,
          data: Grades
        };
      });

    return series;
  }

  return (
    <div className="App">
      <AppBar position="fixed"><Toolbar><Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>Gradebook</Typography></Toolbar></AppBar>
      <Box component="main" sx={{ display: "flex", flexDirection: "column", p: 2, gap: 2 }}>
        <Toolbar />
        <DataTable title="Student List" rows={studentModels} setRows={setStudentModels} dataColumns={studentCols} service={studentService} />
        <DataTable title="Course List" rows={courseModels} setRows={setCourseModels} dataColumns={courseCols} service={courseService} />
        <DataTable title="Grade List" rows={getGrades()} setRows={setGradeModels} dataColumns={gradeCols} service={gradeService} />
        <ReactApexChart options={getStudentsCourseGradesChartOptions()} series={getStudentsCourseGradesSeries()} type="bar" height={350} />
      </Box>
    </div>
  );
}

export default App;
