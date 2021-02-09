package com.industry.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_comment")
public class Comment {
	
	 @Id 
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "comment_id")
	 private Long Id;

	 public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	 
	 private String content;
	 
	 private String writer;
	 
	 @ManyToOne
	 @JoinColumn(name = "u_code")
	 private User user;	

	 
	 public User getUser() {
		return user;
	 }

	 public void setUser(User user) {
		this.user = user;
	 }
	 @ManyToOne
	 @JoinColumn(name = "post_id")
	 private Post post;
}
