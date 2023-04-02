package com.example.studentandteacher.repository;

import com.example.studentandteacher.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
    @Query(value = "select t from Teacher t join t.student_teachers st where st.student.id = ?1")
    List<Teacher> findAllByStudentId(String studentId);
}
