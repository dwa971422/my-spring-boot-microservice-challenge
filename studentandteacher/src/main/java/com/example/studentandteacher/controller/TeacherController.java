package com.example.studentandteacher.controller;

import com.example.studentandteacher.model.Teacher;
import com.example.studentandteacher.model.TeacherDTO;
import com.example.studentandteacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        List<TeacherDTO> result = teacherService.getAllTeachers();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/teachers", params = "student_id")
    public ResponseEntity<List<TeacherDTO>> getAllTeachersByStudentId(@RequestParam(value = "student_id") String studentId) {
        List<TeacherDTO> result = teacherService.getAllTeachersByStudentId(studentId);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/teachers", params = "teacher_id")
    public ResponseEntity<TeacherDTO> getTeacherByTeacherId(@RequestParam(value = "teacher_id") String teacherId) {
        TeacherDTO result;

        try {
            result = teacherService.getTeacherByTeacherId(teacherId);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/teachers")
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody Teacher newTeacher) {
        TeacherDTO result = teacherService.createTeacher(newTeacher);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/teachers")
    public ResponseEntity<TeacherDTO> updateTeacher(@RequestParam(value = "teacher_id") String teacherId,
                                                    @RequestParam(value = "updated_name") String updatedName,
                                                    @RequestParam(value = "updated_department") String updatedDepartment) {
        TeacherDTO result;

        try {
            result = teacherService.updateTeacher(teacherId, updatedName, updatedDepartment);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
