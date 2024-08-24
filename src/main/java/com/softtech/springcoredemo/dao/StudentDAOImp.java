package com.softtech.springcoredemo.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softtech.springcoredemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImp implements StudentDAO {
	
	EntityManager em;
	
	@Autowired
	public StudentDAOImp(EntityManager entityManger)
	{
		em = entityManger;
	}
	@Override
	public void createTable() 
	{
		// The issue you're facing is likely due to the fact that the EntityManager is not designed to execute DDL (Data Definition Language) statements like CREATE TABLE. The EntityManager is primarily used for CRUD (Create, Read, Update, Delete) operations on entities.
		System.out.println("----------------------");
		System.out.println("Getting Command...");
		String SQLCommand = "";
		String Path = "./DB_Query/02-student-tracker.sql";
		 try {
	            File myFile = new File(Path);
	            Scanner myReader = new Scanner(myFile);
	            while (myReader.hasNextLine()) {
	                String data = myReader.nextLine();
	                SQLCommand += data;
	                SQLCommand += "\n";
	                //System.out.println(data);
	            }
	            myReader.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
		 System.out.println(SQLCommand);
		 System.out.println("Posting Command...");
		 Query nativeQuery = em.createNativeQuery(SQLCommand);
		 nativeQuery.executeUpdate();
		 System.out.println(nativeQuery);
		 System.out.println("Created.. Done ^^");
		 System.out.println("---------------------------");
	}
	
	// Insert
	@Override
	@Transactional
	public void insert(Student student) {
		em.persist(student);
	}
	
	// Read
	@Override
	public Student getRecordById(int id) {
		return em.find(Student.class, id);
		
	}

	@Override
	public List<Student> getRecords() {
		TypedQuery<Student> query = em.createQuery("FROM Student",Student.class); // check NativeQuery
		return query.getResultList();
	}
	
	@Override
	public List<Student> getRecords(String condition) {
		TypedQuery<Student> query = em.createQuery("FROM Student Where " + condition,Student.class); // check NativeQuery
		return query.getResultList();
	}

	@Override
	public List<Student> getRecordsWithFirstName(String firstName) {
		TypedQuery<Student> query = em.createQuery("FROM Student Where firstName='" + firstName+"'",Student.class);
		return query.getResultList();
	}

	@Override
	public List<Student> getRecordsWithLastName(String lastName) {
		TypedQuery<Student> query = em.createQuery("FROM Student Where lastName= '" + lastName+"'",Student.class); 
		return query.getResultList();
	}

	@Override
	public List<Student> findByEmail(String email) {
		TypedQuery<Student> query = em.createQuery("FROM Student Where email =:data",Student.class); 
		query.setParameter("data", email);
		return query.getResultList(); // only one
	}
	
//	@Override
//	public List<Student> getRecords(String condition , String data) {
//		TypedQuery<Student> query = em.createQuery("FROM Student Where " + condition +":data",Student.class);
//		query.setParameter("data", data);
//		return query.getResultList();
//	}
	
	// Update
	
	@Override
	@Transactional
	public void updateStudent(Student student) {
		em.merge(student);
	}

	
	@Override
	@Transactional
	public void updateStudentFirstName(int id, String FirstName) {
		Student student = getRecordById(id);
		student.setFirstName(FirstName);
		em.merge(student);
	}

	@Override
	@Transactional
	public void updateStudentLastName(int id, String LastName) {
		Student student = getRecordById(id);
		student.setLastName(LastName);
		em.merge(student);
	}

	@Override
	@Transactional
	public void updateStudentEmail(int id, String email) {
		Student student = getRecordById(id);
		student.setEmail(email);
		em.merge(student);
	}

	@Override
	@Transactional
	public int bulkupdateStudentFirstName(String FirstName) {
		int numRowsUpdated = em.createQuery("Update Student set firstName= '" + FirstName+"'").executeUpdate(); 
		return numRowsUpdated;
	}

	@Override
	@Transactional
	public int bulkupdateStudentLastName(String LastName) {
		int numRowsUpdated = em.createQuery("Update Student set lastName= '" + LastName+"'").executeUpdate(); 
		return numRowsUpdated;
	}

	

//	@Override
//	@Transactional
//	public void bulkupdateStudentEmail(String email) {
//		int numRowsUpdated = em.createQuery("Update Student set email= '" + email+"'").executeUpdate(); 
//		
//	}
	
	// Delete
	
	@Override
	@Transactional
	public void deleteStudent(int id) {
		Student student = getRecordById(id);
		em.remove(student);
	}
	
	@Override
	@Transactional
	public int deleteStudentConditionBased(String condition) {
		int numRowsDeleted;
		try {
		 numRowsDeleted = em.createQuery("Delete from Student Where " + condition).executeUpdate(); 
		}
		catch (Exception e) 
		{
			numRowsDeleted = -1;
		}
		return numRowsDeleted;
	}
	
	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted = em.createQuery("Delete from Student").executeUpdate(); 
		// Reset Id Counter same as Truncate
		Query nativeQuery = em.createNativeQuery("ALTER TABLE student_tracker.student AUTO_INCREMENT = 1");
		nativeQuery.executeUpdate();
		System.out.println(nativeQuery);
		return numRowsDeleted;
	}
	
	@Override
	@Transactional
	public void deleteAllNative() {
		
		Query nativeQuery = em.createNativeQuery("Truncate student_tracker.student");
		nativeQuery.executeUpdate();
	}
	@Override
	@Transactional
	public void dropTable() {
		Query nativeQuery = em.createNativeQuery("DROP TABLE student_tracker.student");
		nativeQuery.executeUpdate();
	}
	
}
