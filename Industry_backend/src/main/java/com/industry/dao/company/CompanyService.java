package com.industry.dao.company;

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
import com.industry.dto.company.CompanyTO;
import com.industry.entity.Community;
import com.industry.entity.Company;
import com.industry.service.community.CommunityRepository;
import com.industry.service.company.CompanyRepository;
import com.industry.springboot.exception.ResourceNotFoundException;
import com.industry.springboot.model.Employee;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyResp;

	
	// get all community
	public List<Company> getAllCompany(){
		return companyResp.findAll();
	}

	public List<Company> getByCompanylocation(String location){
		return companyResp.findByCompanyLocationContaining(location);
	}

	
	public List<Company> getByCompanyName(String name){
		System.out.println(name);
		return companyResp.findByCompanyNameContaining(name);
	}

	public List<Company> getByDyanamicKeyword(CompanyTO companyTO){
		if (companyTO==null){
			List<Company> li=null;
			return li;
		}
		if (companyTO.getLocation()!=null) {
			return companyResp.findByCompanyLocationContaining(companyTO.getLocation());
		}
		else {
			return companyResp.findByCompanyNameContaining(companyTO.getName());
		}
	
	}
	
	
//	// insert coulmn into coummunity table using post
//	public void createCommunity(Community community) {
//		communityResp.save(community);
//	}
//
//	
//	// get coulmn from coummunity table using getmapping
//	public ResponseEntity<Community> getCommunityById(@PathVariable Long bcode) {
//		Community community = communityResp.findById(bcode)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + bcode));
//		return ResponseEntity.ok(community);
//	}
//	
//	public ResponseEntity<Community> updateCommunity(@PathVariable Long bcode, @RequestBody Community communityTO){
//		Community community = communityResp.findById(bcode)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + bcode));
//		
//		community.setTitle(communityTO.getTitle());
//		community.setContent(communityTO.getContent());
//		community.setDate(communityTO.getDate());
//		
//		Community updatedCommunity = communityResp.save(community);
//		return ResponseEntity.ok(updatedCommunity);
//	}
//
//	public void deleteCommunity(@PathVariable Long bcode){
//		Community community = communityResp.findById(bcode)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + bcode));
//		communityResp.delete(community);
//	}
//
	
}
