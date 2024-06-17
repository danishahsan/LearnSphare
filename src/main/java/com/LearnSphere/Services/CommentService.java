package com.LearnSphere.Services;

import java.util.List;

import com.LearnSphere.Entity.Comments;

public interface CommentService {
	
	void addComment(Comments comment);
	
	List<Comments> getAllComment();

}
