package com.industry.rest.review;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.industry.common.ResourceNotFoundException;
import com.industry.dao.community.CommunityService;
import com.industry.dao.company.CompanyService;
import com.industry.dao.review.ReviewService;
import com.industry.dao.user.UserService;
import com.industry.dto.community.CommunityTO;
import com.industry.dto.user.UserTO;
import com.industry.entity.Community;
import com.industry.entity.Company;
import com.industry.entity.Review;
import com.industry.entity.User;
import com.industry.service.company.CompanyRepository;
import com.industry.service.review.ReviewRepository;
import com.industry.service.user.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/review")
public class ReviewCtrl {
	@Autowired
	private CompanyRepository companyRepository;


	@Autowired
	private ReviewService reviewServ;


	@GetMapping("/{companyName}")
	public Long returnCompanyId(@PathVariable String companyName){
		Company company = companyRepository.findByCompanyName(companyName).get();
		return company.getCompanyId();
	}
	
    @PostMapping("/{CompanyId}/{ucode}")
    public void saveReview(@RequestBody Review review,@PathVariable Long CompanyId,@PathVariable Long ucode) {
    	reviewServ.saveReview(CompanyId, ucode, review);
    }
    
    @PostMapping("/{companyId}")
    public List<Review> getReviewByComapanyId(@PathVariable Long companyId){
    	return reviewServ.getReviewByCompanyId(companyId);
    }
    
//    @GetMapping("/company/{ucode}")
//    public  List<Company> createCompanyByUcode(@PathVariable Long ucode) {
//        return companyServ.createCompanyByUcode(ucode);
//    }
//
//    @PostMapping("")
//    public void createSystemCode(@RequestBody User user) {
//    	userServ.createUser(user);
//    }

}
