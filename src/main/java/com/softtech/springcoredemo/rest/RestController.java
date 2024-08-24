package com.softtech.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

//import com.softtech.springcoredemo.*;
//import com.softtech.springcoredemo.common.ChessCoach;
import com.softtech.springcoredemo.common.Coach;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	private Coach myCoach;
	
	@Autowired
	private Coach yourCoach;
//	@Autowired // opt when no constructor overloading (constructor injection when the dependency is essintial)
//	public RestController(Coach myCoach)
//	{
//		this.myCoach = myCoach;
//	}
	
	@Autowired // setter injection when the dependency is optional
	public void setCoach(@Qualifier("instructor") Coach myCoach) // chessCoach
	{
		this.myCoach = myCoach;
	}
		
		@GetMapping("/")
		String getInfo() {
			return myCoach.getInfo();
		}
		
		// field injection
		@GetMapping("/info")
		String getInfo2() {
			return yourCoach.getInfo();
		}
}
