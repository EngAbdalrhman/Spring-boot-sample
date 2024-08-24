package com.softtech.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class ChessCoach implements Coach{

	public ChessCoach() {
		System.out.println("integretings form " + getClass().getSimpleName());
	}
	
	@PostConstruct
	public String getInit() {
		return "Welcome NTG Clarity";
	}
	
	@PreDestroy
	public String getDown() {
		return "Bye TSK";
	}
	
	@Override
	public String getInfo() {
		
		return "My Coach is GM Basem Amin";
	}

}
