package com.example.studentandteacher.model;

import lombok.Data;

@Data
public class StudentDTO {
    private String id;
    private String name;
    private String major;

    private StudentDTO(StudentDTOBuilder studentDTOBuilder) {
        this.id = studentDTOBuilder.id;
        this.name = studentDTOBuilder.name;
        this.major = studentDTOBuilder.major;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public static class StudentDTOBuilder {
        private String id;
        private String name;
        private String major;

        public StudentDTOBuilder() {}

        public StudentDTOBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public StudentDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentDTOBuilder setMajor(String major) {
            this.major = major;
            return this;
        }

        public StudentDTO build() {
            return new StudentDTO(this);
        }
    }
}
