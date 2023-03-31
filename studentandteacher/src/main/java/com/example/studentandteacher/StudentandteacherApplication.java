package com.example.studentandteacher;

import com.example.studentandteacher.model.Student;
import com.example.studentandteacher.model.Student_Teacher;
import com.example.studentandteacher.model.Teacher;
import com.example.studentandteacher.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.HashSet;

@SpringBootApplication
@EnableEurekaClient
public class StudentandteacherApplication implements CommandLineRunner {
	private final StudentService studentService;

	@Autowired
	public StudentandteacherApplication(StudentService studentService) {
		this.studentService = studentService;
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentandteacherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student("kn95", "Ken", "CS", new HashSet<>());
		Student student2 = new Student("dv97", "David", "ME", new HashSet<>());
		Student student3 = new Student("ug98", "Ugo", "Math", new HashSet<>());

		Teacher teacher1 = new Teacher("bf76", "Biff", "CS", new HashSet<>());
		Teacher teacher2 = new Teacher("jm63", "James", "ME", new HashSet<>());
		Teacher teacher3 = new Teacher("mk55", "Mack", "Math", new HashSet<>());
		Teacher teacher4 = new Teacher("ch70", "Chris", "Physics", new HashSet<>());

		Student_Teacher st1 = new Student_Teacher(student1, teacher1);
		Student_Teacher st2 = new Student_Teacher(student1, teacher2);
		Student_Teacher st3 = new Student_Teacher(student2, teacher3);
		Student_Teacher st4 = new Student_Teacher(student2, teacher4);
		Student_Teacher st5 = new Student_Teacher(student3, teacher1);
		Student_Teacher st6 = new Student_Teacher(student3, teacher2);
		Student_Teacher st7 = new Student_Teacher(student3, teacher3);
		Student_Teacher st8 = new Student_Teacher(student3, teacher4);

		student1.getStudent_teachers().add(st1);
		student1.getStudent_teachers().add(st2);

		student2.getStudent_teachers().add(st3);
		student2.getStudent_teachers().add(st4);

		student3.getStudent_teachers().add(st5);
		student3.getStudent_teachers().add(st6);
		student3.getStudent_teachers().add(st7);
		student3.getStudent_teachers().add(st8);

		studentService.createStudent(student1);
		studentService.createStudent(student2);
		studentService.createStudent(student3);
	}
}
