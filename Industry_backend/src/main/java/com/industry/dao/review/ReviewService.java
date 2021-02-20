package com.industry.dao.review;

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
import com.industry.entity.Review;
import com.industry.entity.User;
import com.industry.service.comment.CommentRepository;
import com.industry.service.community.CommunityRepository;
import com.industry.service.company.CompanyRepository;
import com.industry.service.post.PostRepository;
import com.industry.service.review.ReviewRepository;
import com.industry.service.user.UserRepository;
import com.industry.springboot.model.Employee;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	ReviewRepository reviewRepository;
 
	@Autowired
	UserRepository userRepository;
//
//	public List<Comment> getPostComments(Long id){
//		Post post = postRepository.findById(id).get();
//		return commentRepository.findCommentsByPost(post);
//	}
//	
	public void saveReview(Long CompanyId,Long ucode,Review reviewTO) {
		Company company=companyRepository.findById(CompanyId).get();
		User user=userRepository.findById(ucode).get();
		reviewTO.setUser(user);
		reviewTO.setCompany(company);
		reviewRepository.save(reviewTO);
	}
	
	public List<Review> getReviewByCompanyId(Long companyId) {
		return reviewRepository.findByCompanyId(companyId);
		
	}

}
