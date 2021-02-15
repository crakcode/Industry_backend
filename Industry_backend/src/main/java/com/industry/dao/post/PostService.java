package com.industry.dao.post;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.industry.dto.community.CommunityTO;
import com.industry.entity.Community;
import com.industry.entity.Post;
import com.industry.entity.User;
import com.industry.service.community.CommunityRepository;
import com.industry.service.post.PostRepository;
import com.industry.service.user.UserRepository;
import com.industry.common.ResourceNotFoundException;
import com.industry.springboot.model.Employee;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostService {
	
	@Autowired
	private PostRepository postResp;

	@Autowired
	private UserRepository userResp;

	
	// get all community
	public List<Post> getAllPost(){
		return postResp.findAll();
	}
	
	
	// insert coulmn into coummunity table using post
	public void createPost(Post post,Long ucode) {
		post.setWriter(userResp.findById(ucode).get().getName());
		User user=userResp.findById(ucode)
				.orElseThrow(() -> new ResourceNotFoundException("post not exist with id :" + ucode));
		System.out.println(postResp.count()+1);
		post.setId((long) postResp.count()+1);
		post.setUser(user);
		postResp.save(post);
	}

	
	// get coulmn from coummunity table using getmapping
	public ResponseEntity<Post> getPostById(@PathVariable Long id) {
		Post post = postResp.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("post not exist with id :" + id));
		
		return ResponseEntity.ok(post);
	}
	
	public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postTO){
		Post post = postResp.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("post not exist with id : :" + id));
		
		post.setTitle(postTO.getTitle());
		post.setContent(postTO.getContent());
		Post updatedPost = postResp.save(post);
		return ResponseEntity.ok(updatedPost);
	}

	public void deletePost(Long id){
		Post post = postResp.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("post not exist with id : :" + id));
		postResp.delete(post);
	}

	
}
