package com.LearnSphere.Services;

import java.util.List;

import com.LearnSphere.Entity.Course;
import com.LearnSphere.Entity.Lesson;

public interface TrainerService {
	
	public String addCourse(Course c);
	public Course getCourse(int Id);
	public void addLesson(Lesson lesson);
	
	public List<Course> courseList();

}
