/**
 * 
 */
package com.sumit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.models.Comment;
import com.sumit.models.Photo;
import com.sumit.service.CommentService;
import com.sumit.service.PhotoService;

/**
 * @author Sumit
 *
 */
@RestController
@RequestMapping("/rest")
public class CommentResource {
	
	@Autowired
	PhotoService photoService;
	
/*	@Autowired
	CommentService commentService;*/
	
	@RequestMapping(value="/comment/add",method=RequestMethod.POST)
	public void addComment(@RequestBody Comment comment){
		/*Photo photo = photoService.findByPhotoId(comment.getPhotoId());
		List<Comment> commentList = photo.getCommentList();
		comment.setPhoto(photo);
		commentService.save(comment);*/
	}
	
}
