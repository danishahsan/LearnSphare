package com.LearnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LearnSphere.Entity.Comments;

public interface CommentRepo extends JpaRepository<Comments, Integer>{


}
