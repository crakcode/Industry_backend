package com.industry.dao.community;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.industry.dto.community.CommunityTO;
import com.industry.entity.Community;
import com.industry.service.community.CommunityRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CommunityService {
	
	
    private final ModelMapper modelMapper;

	private final CommunityRepository resp;

	public void save(Community Community) {
		resp.save(Community);
	}
	
	public void saveentity(CommunityTO communityTO) {
		Community coummunity=null;
		modelMapper.map(communityTO,coummunity);
		
	}
	

}
