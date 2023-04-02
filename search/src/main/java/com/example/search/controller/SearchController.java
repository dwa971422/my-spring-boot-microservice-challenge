package com.example.search.controller;

import com.example.search.model.SearchServiceResponse;
import com.example.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/asyncstudents")
    public ResponseEntity<SearchServiceResponse> getAllStudentsAndAllEntries() {
        SearchServiceResponse response = searchService.getAllStudentsAndAllEntries();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/asyncstudents", params = "teacher_id")
    public ResponseEntity<SearchServiceResponse> getAllStudentsByTeacherIdAndAllEntries(@RequestParam(value = "teacher_id") String teacherId) {
        SearchServiceResponse response = searchService.getAllStudentsByTeacherIdAndAllEntries(teacherId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/asyncstudents", params = "student_id")
    public ResponseEntity<SearchServiceResponse> getStudentByStudentIdAndAllEntries(@RequestParam(value = "student_id") String studentId) {
        SearchServiceResponse response = searchService.getStudentByStudentIdAndAllEntries(studentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/asyncteachers")
    public ResponseEntity<SearchServiceResponse> getAllTeachersAndAllEntries() {
        SearchServiceResponse response = searchService.getAllTeachersAndAllEntries();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/asyncteachers", params = "student_id")
    public ResponseEntity<SearchServiceResponse> getAllTeachersByStudentIdAndAllEntries(@RequestParam(value = "student_id") String studentId) {
        SearchServiceResponse response = searchService.getAllTeachersByStudentIdAndAllEntries(studentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/asyncteachers", params = "teacher_id")
    public ResponseEntity<SearchServiceResponse> getTeacherByTeacherIdAndAllEntries(@RequestParam(value = "teacher_id") String teacherId) {
        SearchServiceResponse response = searchService.getTeacherByTeacherIdAndAllEntries(teacherId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
