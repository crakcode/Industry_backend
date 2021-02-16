package com.industry.dao.comment;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.industry.dto.community.CommunityTO;
import com.industry.entity.Comment;
import com.industry.entity.Community;
import com.industry.entity.Company;
import com.industry.entity.Post;
import com.industry.entity.User;
import com.industry.service.comment.CommentRepository;
import com.industry.service.community.CommunityRepository;
import com.industry.service.company.CompanyRepository;
import com.industry.service.post.PostRepository;
import com.industry.service.user.UserRepository;
import com.industry.springboot.model.Employee;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	CommentRepository commentRepository;
 
	@Autowired
	UserRepository userRepository;

	public List<Comment> getPostComments(Long id){
		Post post = postRepository.findById(id).get();
		return commentRepository.findCommentsByPost(post);
	}

	// Put Update Mapping 
	// params post_id (id) , comment_id(commentID)
	public Comment createComment(Long id, Long ucode,Comment commentTO){
		Optional<Post> postItem = postRepository.findById(id);
		Optional<User> userItem = userRepository.findById(ucode);
		commentTO.setPost(postItem.get());
		commentTO.setUser(userItem.get());
		commentTO.setWriter(userItem.get().getName());
		commentRepository.save(commentTO);
		return commentTO;
	}

//	public Comment updateComment(@PathVariable Long id,@PathVariable Long commentID, @RequestBody Comment commentTO) { 
//		Optional<Post> postItem = postRespository.findById(id);
//		commentTO.setPost(postItem.get());
//		Comment newComment = commentRepository.findById(commentID).get();
//		newComment.setContent(commentTO.getContent());
//		newComment.setWriter(newComment.getUser().getName());
//		return newComment;
// }
	public boolean deleteComment(Long ucode,Long commentID){
		if(ucode==commentRepository.findById(commentID).get().getUser().getUcode()) {
			commentRepository.deleteById(commentID);
			return true;
		}else {
			return false;
		}
	}

}
