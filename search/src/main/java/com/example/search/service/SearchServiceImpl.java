package com.example.search.service;

import com.example.inclassdemo.model.Entry;
import com.example.inclassdemo.service.DataFetchService;
import com.example.search.model.SearchServiceResponse;
import com.example.studentandteacher.model.StudentDTO;
import com.example.studentandteacher.model.TeacherDTO;
import com.example.studentandteacher.service.StudentService;
import com.example.studentandteacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class SearchServiceImpl implements SearchService {
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final DataFetchService dataFetchService;
    private final String URL = "https://api.publicapis.org/entries";

    @Autowired
    public SearchServiceImpl(StudentService studentService, TeacherService teacherService, DataFetchService dataFetchService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.dataFetchService = dataFetchService;
    }

    @Override
    public SearchServiceResponse getAllStudentsAndAllEntries() {
        CompletableFuture<List<StudentDTO>> allStudentsFuture = CompletableFuture.supplyAsync(() -> studentService.getAllStudents());
        CompletableFuture<List<Entry>> allEntriesFuture = CompletableFuture.supplyAsync(() -> dataFetchService.getAllEntries(URL));

        return CompletableFuture.allOf(allStudentsFuture, allEntriesFuture).thenApply((ignored) -> {
            SearchServiceResponse result = new SearchServiceResponse();
            result.setStudentDTOList(allStudentsFuture.join());
            result.setEntryList(allEntriesFuture.join());
            return result;
        }).join();
    }

    @Override
    public SearchServiceResponse getAllStudentsByTeacherIdAndAllEntries(String teacherId) {
        CompletableFuture<List<StudentDTO>> allStudentsFuture = CompletableFuture.supplyAsync(() -> studentService.getAllStudentsByTeacherId(teacherId));
        CompletableFuture<List<Entry>> allEntriesFuture = CompletableFuture.supplyAsync(() -> dataFetchService.getAllEntries(URL));

        return CompletableFuture.allOf(allStudentsFuture, allEntriesFuture).thenApply((ignored) -> {
            SearchServiceResponse result = new SearchServiceResponse();
            result.setStudentDTOList(allStudentsFuture.join());
            result.setEntryList(allEntriesFuture.join());
            return result;
        }).join();
    }

    @Override
    public SearchServiceResponse getStudentByStudentIdAndAllEntries(String studentId) {
        CompletableFuture<List<StudentDTO>> studentFuture = CompletableFuture.supplyAsync(() -> {
            StudentDTO foundStudent = studentService.getStudentByStudentId(studentId);
            return Arrays.asList(foundStudent);
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        });

        CompletableFuture<List<Entry>> allEntriesFuture = CompletableFuture.supplyAsync(() -> dataFetchService.getAllEntries(URL));

        return CompletableFuture.allOf(studentFuture, allEntriesFuture).thenApply((ignored) -> {
            SearchServiceResponse result = new SearchServiceResponse();
            result.setStudentDTOList(studentFuture.join());
            result.setEntryList(allEntriesFuture.join());
            return result;
        }).join();
    }

    @Override
    public SearchServiceResponse getAllTeachersAndAllEntries() {
        CompletableFuture<List<TeacherDTO>> allTeachersFuture = CompletableFuture.supplyAsync(() -> teacherService.getAllTeachers());
        CompletableFuture<List<Entry>> allEntriesFuture = CompletableFuture.supplyAsync(() -> dataFetchService.getAllEntries(URL));

        return CompletableFuture.allOf(allTeachersFuture, allEntriesFuture).thenApply((ignored) -> {
            SearchServiceResponse result = new SearchServiceResponse();
            result.setTeacherDTOList(allTeachersFuture.join());
            result.setEntryList(allEntriesFuture.join());
            return result;
        }).join();
    }

    @Override
    public SearchServiceResponse getAllTeachersByStudentIdAndAllEntries(String studentId) {
        CompletableFuture<List<TeacherDTO>> allTeachersFuture = CompletableFuture.supplyAsync(() -> teacherService.getAllTeachersByStudentId(studentId));
        CompletableFuture<List<Entry>> allEntriesFuture = CompletableFuture.supplyAsync(() -> dataFetchService.getAllEntries(URL));

        return CompletableFuture.allOf(allTeachersFuture, allEntriesFuture).thenApply((ignored) -> {
            SearchServiceResponse result = new SearchServiceResponse();
            result.setTeacherDTOList(allTeachersFuture.join());
            result.setEntryList(allEntriesFuture.join());
            return result;
        }).join();
    }

    @Override
    public SearchServiceResponse getTeacherByTeacherIdAndAllEntries(String teacherId) {
        CompletableFuture<List<TeacherDTO>> teacherFuture = CompletableFuture.supplyAsync(() -> {
            TeacherDTO foundTeacher = teacherService.getTeacherByTeacherId(teacherId);
            return Arrays.asList(foundTeacher);
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        });

        CompletableFuture<List<Entry>> allEntriesFuture = CompletableFuture.supplyAsync(() -> dataFetchService.getAllEntries(URL));

        return CompletableFuture.allOf(teacherFuture, allEntriesFuture).thenApply((ignored) -> {
            SearchServiceResponse result = new SearchServiceResponse();
            result.setTeacherDTOList(teacherFuture.join());
            result.setEntryList(allEntriesFuture.join());
            return result;
        }).join();
    }
}
