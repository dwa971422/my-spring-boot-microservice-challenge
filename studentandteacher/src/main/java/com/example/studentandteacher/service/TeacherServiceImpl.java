package com.example.studentandteacher.service;

import com.example.studentandteacher.model.Teacher;
import com.example.studentandteacher.model.TeacherDTO;
import com.example.studentandteacher.model.TeacherDTO.TeacherDTOBuilder;
import com.example.studentandteacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(teacher -> new TeacherDTOBuilder()
                        .setId(teacher.getId())
                        .setName(teacher.getName())
                        .setDepartment(teacher.getDepartment())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<TeacherDTO> getAllTeachersByStudentId(String studentId) {
        return teacherRepository.findAllByStudentId(studentId)
                .stream()
                .map(teacher -> new TeacherDTOBuilder()
                        .setId(teacher.getId())
                        .setName(teacher.getName())
                        .setDepartment(teacher.getDepartment())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO getTeacherByTeacherId(String teacherId) {
        Teacher foundTeacher = teacherRepository.findById(teacherId).orElseThrow(() ->
                new NoSuchElementException("Teacher with ID " + teacherId + " NOT FOUND!"));

        return new TeacherDTOBuilder()
                .setId(foundTeacher.getId())
                .setName(foundTeacher.getName())
                .setDepartment(foundTeacher.getDepartment())
                .build();
    }

    @Override
    public TeacherDTO createTeacher(Teacher newTeacher) {
        Teacher createdTeacher = teacherRepository.save(newTeacher);

        return new TeacherDTOBuilder()
                .setId(createdTeacher.getId())
                .setName(createdTeacher.getName())
                .setDepartment(createdTeacher.getDepartment())
                .build();
    }

    @Override
    public TeacherDTO updateTeacher(String teacherId, String updatedName, String updatedDepartment) {
        Teacher foundTeacher = teacherRepository.findById(teacherId).orElseThrow(() ->
                new NoSuchElementException("Teacher with ID " + teacherId + " NOT FOUND!"));

        foundTeacher.setName(updatedName);
        foundTeacher.setDepartment(updatedDepartment);

        Teacher savedUpdatedTeacher = teacherRepository.save(foundTeacher);

        return new TeacherDTOBuilder()
                .setId(savedUpdatedTeacher.getId())
                .setName(savedUpdatedTeacher.getName())
                .setDepartment(savedUpdatedTeacher.getDepartment())
                .build();
    }
}
