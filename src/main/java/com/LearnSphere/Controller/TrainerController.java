package com.LearnSphere.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LearnSphere.Entity.Comments;
import com.LearnSphere.Entity.Course;
import com.LearnSphere.Entity.Lesson;
import com.LearnSphere.Services.CommentService;
import com.LearnSphere.Services.TrainerService;

@Controller
public class TrainerController {
	
	@Autowired
	TrainerService ts;
	
	@Autowired
	CommentService cService;
	
	@PostMapping("/addCourse")
	public String addCourse(@RequestParam("courseId") int c_id,@RequestParam("courseName") String c_name,@RequestParam("coursePrice") int c_price)
	{
		Course c=new Course();
		
		c.setCourseId(c_id);
		c.setCourseName(c_name);
		c.setCoursePrice(c_price);
		
		ts.addCourse(c);
		return "redirect:/";
	}
	
	
	@PostMapping("/lesson")
	public String addLesson(@RequestParam("courseId") int c_id,@RequestParam("lessonId") int l_Id,@RequestParam("lessonName") String l_Name,
							@RequestParam("lessonTopic")String l_Topic,@RequestParam("lessonLink")String l_Link)
	{
		Course c=ts.getCourse(c_id);
		Lesson lesson= new Lesson(l_Id,l_Name,l_Topic,l_Link,c);
		ts.addLesson(lesson);
		
		c.getLessons().add(lesson);
		return "redirect:/";
	}
	
	
	
	@GetMapping("/showCourses")
	public String showCourses(Model course, Model comment )
	{
		List<Course> courseList=ts.courseList();
		System.out.println(courseList);
		course.addAttribute("courseList",courseList);
		
		List<Comments> commentList= cService.getAllComment();
		comment.addAttribute("comments",commentList);
		return "showCourses";
	}
	
	
	
	

}
