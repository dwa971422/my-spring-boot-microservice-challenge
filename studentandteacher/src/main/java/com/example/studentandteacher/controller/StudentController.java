package com.example.studentandteacher.controller;

import com.example.studentandteacher.model.Student;
import com.example.studentandteacher.model.StudentDTO;
import com.example.studentandteacher.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> result = studentService.getAllStudents();

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/students", params = "teacher_id")
    public ResponseEntity<List<StudentDTO>> getAllStudentsByTeacherId(@RequestParam(value = "teacher_id") String teacherId) {
        List<StudentDTO> result = studentService.getAllStudentsByTeacherId(teacherId);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/students", params = "student_id")
    public ResponseEntity<StudentDTO> getStudentByStudentId(@RequestParam(value = "student_id") String studentId) {
        StudentDTO result;

        try {
            result = studentService.getStudentByStudentId(studentId);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody Student newStudent) {
        StudentDTO result = studentService.createStudent(newStudent);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/students")
    public ResponseEntity<StudentDTO> updateStudent(@RequestParam(value = "student_id") String studentId,
                                                    @RequestParam(value = "updated_name") String updatedName,
                                                    @RequestParam(value = "updated_major") String updatedMajor) {
        StudentDTO result;

        try {
            result = studentService.updateStudent(studentId, updatedName, updatedMajor);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
