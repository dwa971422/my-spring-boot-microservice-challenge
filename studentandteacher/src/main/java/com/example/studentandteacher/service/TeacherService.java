package com.example.studentandteacher.service;

import com.example.studentandteacher.model.Teacher;
import com.example.studentandteacher.model.TeacherDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> getAllTeachers();

    List<TeacherDTO> getAllTeachersByStudentId(String studentId);

    TeacherDTO getTeacherByTeacherId(String teacherId);

    TeacherDTO createTeacher(Teacher newTeacher);

    TeacherDTO updateTeacher(String teacherId, String updatedName, String updatedDepartment);
}
