package com.softtech.springcoredemo.config;

import org.springframework.context.annotation.Bean;

import com.softtech.springcoredemo.common.Coach;
import com.softtech.springcoredemo.common.ProgrammingCoach;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean //("customeBeanID") overrides beanID => method Name = instructor
	public Coach instructor() 
	{
		System.out.println("Importing Tech Coach....");
		return new ProgrammingCoach();
	}
}
