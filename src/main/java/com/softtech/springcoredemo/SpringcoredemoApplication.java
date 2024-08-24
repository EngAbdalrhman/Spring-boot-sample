package com.softtech.springcoredemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.softtech.springcoredemo.dao.StudentDAO;
import com.softtech.springcoredemo.dao.StudentDAOImp;
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
//		createStudent(studentDao);
//		readStudent(studentDao,1);
//		readStudent(studentDao,2);
//		readStudents(studentDao);
		// TRY Conditions as in SQL
//		readStudents(studentDao,"firstName = 'Abdalrhman' ");
//		readStudents(studentDao,"firstName = 'Abdalrhman' OR lastName = 'Salah' ");
//		readStudents(studentDao,"order by firstName DESC"); // default asc
//		readStudents(studentDao,"firstName =","Mohamed");
		findByEmail(studentDao,"mo@salah.eg");
	};

	}
	public void createStudent(StudentDAO studentDao) {
		System.out.println("----------------------------");
		System.out.println("Creating a student object...");
		Student student = new Student("Mohamed","Salah","mo@salah.eg");
		System.out.println("Saving a Student...");
		System.out.println("the id =" + student.getId());
		studentDao.insert(student);
		
		System.out.println("Saved student, the id =" + student.getId());
		System.out.println("----------------------------");
	}
	public void readStudent(StudentDAO studentDao,int id) {
		System.out.println("----------------------------");
		
		Student student = studentDao.getRecordById(id);
		
		System.out.println(student.toString());
		System.out.println("----------------------------");
	}
	public void readStudents(StudentDAO studentDao) {
		System.out.println("----------------------------");
		
		List<Student> students = studentDao.getRecords();
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("----------------------------");
	}
	
	public void readStudents(StudentDAO studentDao,String condition) {
		System.out.println("----------------------------");
		
		List<Student> students = studentDao.getRecords(condition);
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("----------------------------");
	}
	
	public void findByEmail(StudentDAO studentDao,String email) {
		System.out.println("----------------------------");
		
		List<Student> students = studentDao.findByEmail(email);
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("----------------------------");
	}
	
//	public void readStudents(StudentDAO studentDao,String condition,String data) {
//		System.out.println("----------------------------");
//		
//		List<Student> students = studentDao.getRecords(condition,data);
//		for (Student student : students) {
//			System.out.println(student.toString());
//		}
//		System.out.println("----------------------------");
//	}
}
