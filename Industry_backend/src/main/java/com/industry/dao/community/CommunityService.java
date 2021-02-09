package com.industry.dao.community;

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
import com.industry.service.community.CommunityRepository;
import com.industry.common.ResourceNotFoundException;
import com.industry.springboot.model.Employee;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommunityService {
	
	@Autowired
	private CommunityRepository communityResp;

	
	// get all community
	public List<Community> getAllCommunity(){
		return communityResp.findAll();
	}

	// insert coulmn into coummunity table using post
	public void createCommunity(Community community) {
		communityResp.save(community);
	}

	
	// get coulmn from coummunity table using getmapping
	public ResponseEntity<Community> getCommunityById(@PathVariable Long bcode) {
		Community community = communityResp.findById(bcode)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + bcode));
		return ResponseEntity.ok(community);
	}
	
	public ResponseEntity<Community> updateCommunity(@PathVariable Long bcode, @RequestBody Community communityTO){
		Community community = communityResp.findById(bcode)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + bcode));
		
		community.setTitle(communityTO.getTitle());
		community.setContent(communityTO.getContent());
		community.setDate(communityTO.getDate());
		
		Community updatedCommunity = communityResp.save(community);
		return ResponseEntity.ok(updatedCommunity);
	}

	public void deleteCommunity(@PathVariable Long bcode){
		Community community = communityResp.findById(bcode)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + bcode));
		communityResp.delete(community);
	}

	
}
