package com.LearnSphere.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LearnSphere.Entity.Lesson;
import com.LearnSphere.Services.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService service;
	
	
	@PostMapping("/myLesson")
	public String getLesson(@RequestParam("id")int id,Model model)
	{
	
		Lesson l=service.getLesson(id);
		model.addAttribute("lesson",l);
		System.out.println(l);
		return "redirect:/";
	}
}
