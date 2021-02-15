package com.industry.rest.news;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
@RequestMapping("/api/v1/news")
public class NewsCtrl {
	
	  @Autowired
	  private PostService postServ;

	  @GetMapping("")
	  public void getAllPost(){
			String url = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query=산업기능요원";
			Document doc = null;
			try {
				doc = Jsoup.connect(url).get();
				doc.select("div.group_news").select("li.bx");
				System.out.println(doc.select("div.group_news").select("li.bx").select("title"));
			} catch (IOException e) {
				e.printStackTrace();
			}
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
