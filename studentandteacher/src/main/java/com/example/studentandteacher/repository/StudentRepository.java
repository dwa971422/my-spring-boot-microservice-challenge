package com.example.studentandteacher.repository;

import com.example.studentandteacher.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query(value = "select s from Student s join s.student_teachers st where st.teacher.id = ?1")
    List<Student> findAllByTeacherId(String teacherId);
}
