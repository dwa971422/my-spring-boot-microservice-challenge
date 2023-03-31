package com.example.studentandteacher.model;

import lombok.Data;

@Data
public class TeacherDTO {
    private String id;
    private String name;
    private String department;

    private TeacherDTO(TeacherDTOBuilder teacherDTOBuilder) {
        this.id = teacherDTOBuilder.id;
        this.name = teacherDTOBuilder.name;
        this.department = teacherDTOBuilder.department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public static class TeacherDTOBuilder {
        private String id;
        private String name;
        private String department;

        public TeacherDTOBuilder() {}

        public TeacherDTOBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public TeacherDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public TeacherDTOBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public TeacherDTO build() {
            return new TeacherDTO(this);
        }
    }
}
