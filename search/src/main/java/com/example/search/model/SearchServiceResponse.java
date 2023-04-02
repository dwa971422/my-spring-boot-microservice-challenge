package com.example.search.model;

import com.example.inclassdemo.model.Entry;
import com.example.studentandteacher.model.StudentDTO;
import com.example.studentandteacher.model.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchServiceResponse {
    List<StudentDTO> studentDTOList;
    List<TeacherDTO> teacherDTOList;
    List<Entry> entryList;
}
