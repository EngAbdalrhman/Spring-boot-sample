package com.softtech.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Primary
public class SwimCoach implements Coach{

	public SwimCoach() {
		System.out.println("integretings form " + getClass().getSimpleName());
	}
	
	@PostConstruct
	public String getInit() {
		return "Hello World";
	}
	
	@PreDestroy
	public String getDown() {
		return "I am Good Swimmer";
	}
	
	@Override
	public String getInfo() {
		return "Ahmed Elgendy";
	}

}
