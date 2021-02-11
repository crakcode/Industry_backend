package com.industry.service.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.industry.entity.Post;



@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	List<Post> findByWriter(String writer);

}
