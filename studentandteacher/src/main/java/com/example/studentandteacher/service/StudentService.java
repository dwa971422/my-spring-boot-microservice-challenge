package com.example.studentandteacher.service;

import com.example.studentandteacher.model.Student;
import com.example.studentandteacher.model.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    List<StudentDTO> getAllStudentsByTeacherId(String teacherId);

    StudentDTO getStudentByStudentId(String studentId);

    StudentDTO createStudent(Student newStudent);

    StudentDTO updateStudent(String studentId, String updatedName, String updatedMajor);
}
