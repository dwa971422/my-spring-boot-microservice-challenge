package com.example.studentandteacher.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "student_teacher")
@AllArgsConstructor
@NoArgsConstructor
public class Student_Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "stu_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tea_id")
    private Teacher teacher;

    public Student_Teacher(Student student, Teacher teacher) {
        this.student = student;
        this.teacher = teacher;
    }
}
