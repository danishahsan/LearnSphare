package com.LearnSphere.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LearnSphere.Entity.Comments;
import com.LearnSphere.repository.CommentRepo;

@Service
public class CommentServiceImp  implements CommentService{

	@Autowired
	CommentRepo cRepo;
	

	@Override
	public List<Comments> getAllComment() {
		
		return cRepo.findAll();
	}

	@Override
	public void addComment(Comments comment) {

		cRepo.save(comment);
	}

	
	
}
