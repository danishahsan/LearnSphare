package com.LearnSphere.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LearnSphere.Entity.Course;
import com.LearnSphere.Entity.Lesson;
import com.LearnSphere.repository.CourseRepository;
import com.LearnSphere.repository.LessonRepository;

@Service
public class TrainerServiceImp implements TrainerService{
	
	@Autowired
	CourseRepository courseRepo;
	@Autowired
	LessonRepository lessonRepo;

	@Override
	public String addCourse(Course c) {

		courseRepo.save(c);
		return "Course has been added successfully!!";
	}

	@Override
	public Course getCourse(int Id) {
		
		return courseRepo.findById(Id).get();
	}

	@Override
	public void addLesson(Lesson lesson) {
		lessonRepo.save(lesson);
	}

	@Override
	public List<Course> courseList() {
		
		return courseRepo.findAll();
	}
	
}
