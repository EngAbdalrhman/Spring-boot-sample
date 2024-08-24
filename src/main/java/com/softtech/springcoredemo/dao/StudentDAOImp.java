package com.softtech.springcoredemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softtech.springcoredemo.entity.Student;

import jakarta.persistence.EntityManager;

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
	

}
