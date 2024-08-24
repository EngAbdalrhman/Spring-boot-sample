package com.softtech.springcoredemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.softtech.springcoredemo.dao.StudentDAO;
import com.softtech.springcoredemo.entity.Student;

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDao) {
	return runner -> {
		// ADD DAO Code
		createStudent(studentDao);

	};

	}
	public void createStudent(StudentDAO studentDao) {
		System.out.println("----------------------------");
		System.out.println("Creating a student object...");
		Student student = new Student("Abdalrhman","Mostafa","abdo@mmk.com");
		System.out.println("Saving a Student...");
		System.out.println("the id =" + student.getId());
		studentDao.insert(student);
		
		System.out.println("Saved student, the id =" + student.getId());
		System.out.println("----------------------------");
	}
	
}
