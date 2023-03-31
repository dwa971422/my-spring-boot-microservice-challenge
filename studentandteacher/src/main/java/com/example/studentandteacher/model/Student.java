package com.example.studentandteacher.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String major;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Student_Teacher> student_teachers;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Set<Student_Teacher> getStudent_teachers() {
        return student_teachers;
    }
}
