package com.softtech.springcoredemo.dao;

import java.util.List;

import com.softtech.springcoredemo.entity.Student;

public interface StudentDAO {
	
	void insert(Student student);
	
	Student getRecordById(int id);
	
	List<Student>getRecords();
	List<Student>getRecords(String condition);
//	List<Student>getRecords(String condition,String data);
	List<Student>getRecordsWithFirstName(String firstName);
	List<Student>getRecordsWithLastName(String lastName);
	List<Student>findByEmail(String email);
}
