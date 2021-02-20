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
@Table(name = "tb_review")
public class Review {
	
	 @Id 
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "review_id")
	 private Long Id;

	 public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column
	 private String review;
	 
	 @Column
	 private int score;
	 
	 @ManyToOne
	 @JoinColumn(name = "u_code")
	 private User user;	

	 @ManyToOne
	 @JoinColumn(name = "companyId")
	 private Company company;
}
