package com.LearnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LearnSphere.Entity.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{

}
