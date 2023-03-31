package com.example.studentandteacher.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String department;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
