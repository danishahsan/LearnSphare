package com.LearnSphere.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.LearnSphere.Services.UserServices;


@Controller
public class NavController {
	@Autowired
	UserServices uService;

//								
//							
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}

// 					SignUp		Page
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}

	@GetMapping("/login")
	public String login()
	{
		return "login";
	}

	@GetMapping("/createCourse")
	public String createCourse()
	{
		return "createCourse";
	}
	
	
	
	@GetMapping("/studentHome")
	public String studentHome()
	{
		return "studentHome";
	}
	
	@GetMapping("/course")
	public String course()
	{
		return "course";
	}
	
	
	
	@GetMapping("/createLesson")
	public String createLesson()
	{
		return "createLesson";
	}
	
	@GetMapping("/demoLesson")
	public String demoLesson()
	{
		return "demoLesson";
	}
	
	@GetMapping("/trainerHome")
	public String trainerHome()
	{
		return "trainerHome";
	}
	
	
	@PostMapping("/buyCourse")
	public String buyCourse()
	{
		return "purchase";
	}
	
	@PostMapping("/myCourse")
	public String myCourse()
	{
		return "myCourse";
	}
	
	

}
