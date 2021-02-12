package com.industry.rest.post;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.industry.dao.community.CommunityService;
import com.industry.dao.post.PostService;
import com.industry.dto.community.CommunityTO;
import com.industry.entity.Community;
import com.industry.entity.Post;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/postboard")
public class PostCtrl {
	
	  @Autowired
	  private PostService postServ;

	  @GetMapping("/list")
	  public List<Post> getAllPost(){
		  return postServ.getAllPost();
	  }
//
	  @GetMapping("/writer/{ucode}")
	  public List<Post> getPostByWriter(@PathVariable Long ucode){
		  	return postServ.getPostByWriter(ucode);
	  }
	  
	  @PostMapping("/{ucode}")
	  public void createPost(@RequestBody Post post,@PathVariable Long ucode) {
	  	postServ.createPost(post,ucode);
	  }

	  @GetMapping("/{id}")
	  public ResponseEntity<Post> getPostById(@PathVariable Long id){
		  return postServ.getPostById(id);
	  }
//    
//    
	  @PutMapping("/{id}")
	  public ResponseEntity<Post> updatePost(@PathVariable Long id,@RequestBody Post post){
		  return postServ.updatePost(id,post);
	  }

	  @DeleteMapping("/{id}")
	  public void deletePost(@PathVariable Long id) {
		  postServ.deletePost(id);
	  }
}
