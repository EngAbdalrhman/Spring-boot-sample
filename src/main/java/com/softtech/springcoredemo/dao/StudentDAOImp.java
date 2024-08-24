package com.softtech.springcoredemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softtech.springcoredemo.entity.Student;

import jakarta.persistence.EntityManager;
//import jakarta.persistence.Query;
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
	@Transactional
	public void insert(Student student) {
		em.persist(student);
	}

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
	
	@Override
	@Transactional
	public void updateStudent(Student student) {
		em.merge(student);
	}

	// Update
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
	
	

	
	
}
