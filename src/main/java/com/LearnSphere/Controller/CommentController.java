package com.LearnSphere.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LearnSphere.Entity.Comments;
import com.LearnSphere.Services.CommentService;

@Controller
public class CommentController {

	@Autowired
	CommentService cService;
	
	
	@PostMapping("/addComment")
	private String addComment(@RequestParam("comment")String comm, Model redi) {
		
		// saving Comment
		Comments comment=new Comments();
		comment.setComment(comm);
		cService.addComment(comment);
		return  "redirect:showCourses";
	}
	
}
