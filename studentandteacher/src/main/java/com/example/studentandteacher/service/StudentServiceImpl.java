package com.example.studentandteacher.service;

import com.example.studentandteacher.model.Student;
import com.example.studentandteacher.model.StudentDTO;
import com.example.studentandteacher.model.StudentDTO.StudentDTOBuilder;
import com.example.studentandteacher.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> new StudentDTOBuilder()
                        .setId(student.getId())
                        .setName(student.getName())
                        .setMajor(student.getMajor())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getAllStudentsByTeacherId(String teacherId) {
        return studentRepository.findAllByTeacherId(teacherId)
                .stream()
                .map(student -> new StudentDTOBuilder()
                        .setId(student.getId())
                        .setName(student.getName())
                        .setMajor(student.getMajor())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentByStudentId(String studentId) {
        Student foundStudent = studentRepository.findById(studentId).orElseThrow(() ->
                new NoSuchElementException("Student with ID " + studentId + " NOT FOUND!"));

        return new StudentDTOBuilder()
                .setId(foundStudent.getId())
                .setName(foundStudent.getName())
                .setMajor(foundStudent.getMajor())
                .build();
    }

    @Override
    public StudentDTO createStudent(Student newStudent) {
        Student createdStudent = studentRepository.save(newStudent);

        return new StudentDTOBuilder()
                .setId(createdStudent.getId())
                .setName(createdStudent.getName())
                .setMajor(createdStudent.getMajor())
                .build();
    }

    @Override
    public StudentDTO updateStudent(String studentId, String updatedName, String updatedMajor) {
        Student foundStudent = studentRepository.findById(studentId).orElseThrow(() ->
                new NoSuchElementException("Student with ID " + studentId + " NOT FOUND!"));

        foundStudent.setName(updatedName);
        foundStudent.setMajor(updatedMajor);

        Student savedUpdatedStudent = studentRepository.save(foundStudent);

        return new StudentDTOBuilder()
                .setId(savedUpdatedStudent.getId())
                .setName(savedUpdatedStudent.getName())
                .setMajor(savedUpdatedStudent.getMajor())
                .build();
    }
}
