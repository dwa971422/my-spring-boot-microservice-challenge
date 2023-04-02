package com.example.search.service;

import com.example.search.model.SearchServiceResponse;

public interface SearchService {
    SearchServiceResponse getAllStudentsAndAllEntries();

    SearchServiceResponse getAllStudentsByTeacherIdAndAllEntries(String teacherId);

    SearchServiceResponse getStudentByStudentIdAndAllEntries(String studentId);

    SearchServiceResponse getAllTeachersAndAllEntries();

    SearchServiceResponse getAllTeachersByStudentIdAndAllEntries(String studentId);

    SearchServiceResponse getTeacherByTeacherIdAndAllEntries(String teacherId);
}
