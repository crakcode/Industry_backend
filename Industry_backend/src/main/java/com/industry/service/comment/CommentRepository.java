package com.industry.service.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.industry.entity.Comment;
import com.industry.entity.Post;



@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findCommentsByPost(Post post);

}
