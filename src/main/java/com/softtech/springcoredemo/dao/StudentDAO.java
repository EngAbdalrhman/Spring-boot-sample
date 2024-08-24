package com.softtech.springcoredemo.dao;

import java.util.List;

import com.softtech.springcoredemo.entity.Student;

public interface StudentDAO {
	
	// Create
	void createTable();

	// Insert
	void insert(Student student);
	
	// Read
	Student getRecordById(int id);
	
	List<Student>getRecords();
	List<Student>getRecords(String condition);
//	List<Student>getRecords(String condition,String data);
	List<Student>getRecordsWithFirstName(String firstName);
	List<Student>getRecordsWithLastName(String lastName);
	List<Student>findByEmail(String email);
	
	// Update
	void updateStudent(Student student);
	void updateStudentFirstName(int id,String FirstName);
	void updateStudentLastName(int id,String LastName);
	void updateStudentEmail(int id,String email);
	int bulkupdateStudentFirstName(String FirstName);
	int bulkupdateStudentLastName(String LastName);
//	void bulkupdateStudentEmail(String email); // email is unique

	// Delete
	void deleteStudent(int id);
	public int deleteStudentConditionBased(String condition);
	int deleteAll();
	void deleteAllNative();

	// drop table
	void dropTable();
	
}
