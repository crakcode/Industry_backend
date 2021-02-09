package com.industry.rest.comment;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.industry.dao.comment.CommentService;
import com.industry.dao.community.CommunityService;
import com.industry.dao.company.CompanyService;
import com.industry.dao.user.UserService;
import com.industry.dto.community.CommunityTO;
import com.industry.entity.Comment;
import com.industry.entity.Community;
import com.industry.entity.Company;
import com.industry.entity.Post;
import com.industry.entity.User;
import com.industry.service.comment.CommentRepository;
import com.industry.service.post.PostRepository;
import com.industry.service.user.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/post")
@RestController
public class CommentCtrl {
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	CommentRepository commentRepository;
 
	@Autowired
	UserRepository userRepository;

	
	@Autowired
	CommentService commentServ;
	
	// 1. 특정 게시글에 있는 comment를 불러온다.
	// param: id(Post id)
	
	@GetMapping("/{id}/comment")
	public List<Comment> getPostComments(@PathVariable Long id){
		return commentServ.getPostComments(id);
	}
 
	
	// 댓글 입력하기 id값과 ucode값을 받는다.
	@PostMapping("/{id}/{ucode}/comment")
	public Comment createComment(@PathVariable Long id,@PathVariable Long ucode, @RequestBody Comment commentTO){
		return commentServ.createComment(id,ucode,commentTO);
	}
 
	
	@PostMapping("/post/{id}/comment/{commentID}")
	public Comment updateComment(@PathVariable Long id,@PathVariable Long commentID, @RequestBody Comment commentTO) { 
		Optional<Post> postItem = postRepository.findById(id);
		commentTO.setPost(postItem.get());
		Comment newComment = commentRepository.findById(commentID).get();
		newComment.setContent(commentTO.getContent());
		newComment.setWriter(newComment.getUser().getName());
	return newComment;
 }

 
	@DeleteMapping("/{id}/comment/{commentID}")
	public String deleteComment(@PathVariable Long id, @PathVariable Long commentID){
		return commentServ.deleteComment(id,commentID);
	}
 }