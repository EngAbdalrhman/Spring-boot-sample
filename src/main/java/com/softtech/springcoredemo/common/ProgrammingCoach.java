package com.softtech.springcoredemo.common;

public class ProgrammingCoach implements Coach{
	
	public ProgrammingCoach() {
		System.out.println("integretings form " + getClass().getSimpleName());
	}
	@Override
	public String getInfo() {
		return "This is CS50";
	}

}
