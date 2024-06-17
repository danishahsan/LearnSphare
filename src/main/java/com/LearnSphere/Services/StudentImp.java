package com.LearnSphere.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LearnSphere.Entity.Lesson;
import com.LearnSphere.repository.LessonRepository;


@Service
public class StudentImp implements StudentService  {

	@Autowired
	LessonRepository lrepo;

	@Override
	public Lesson getLesson(int id) {
		Lesson l =lrepo.findById(id).get();
		return l;
	}
	
}
